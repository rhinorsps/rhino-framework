package org.rhino.rsps.net.netty.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.ReferenceCountUtil;
import org.rhino.rsps.net.netty.Attributes;
import org.rhino.rsps.net.session.Session;
import org.rhino.rsps.net.session.SessionContext;
import org.rhino.rsps.net.session.SessionManager;

import java.net.InetSocketAddress;

public class SessionHandler extends SimpleChannelInboundHandler<Object> {

    /**
     * The session manager
     */
    private final SessionManager manager;

    public SessionHandler(SessionManager manager) {
        this.manager = manager;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object object) throws Exception {
        try {
            if (!channelHandlerContext.channel().hasAttr(Attributes.SESSION)) {
                throw new NullPointerException("session");
            }
            channelHandlerContext.channel().attr(Attributes.SESSION).get().read(object);
        } finally {
            ReferenceCountUtil.release(object);
        }
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        Session session = this.manager.createAndRegister((InetSocketAddress) ctx.channel().remoteAddress());
        ctx.channel().attr(Attributes.SESSION).setIfAbsent(session);
        session.getContext().setState(SessionContext.State.CONNECTED);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        this.manager.unregister(ctx.channel().attr(Attributes.SESSION).getAndSet(null));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);

        cause.printStackTrace(); // TODO: FIXME
    }
}
