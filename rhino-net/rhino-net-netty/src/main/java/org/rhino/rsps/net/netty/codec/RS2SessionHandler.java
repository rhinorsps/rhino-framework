package org.rhino.rsps.net.netty.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.rhino.rsps.net.netty.NettyStatefulSession;
import org.rhino.rsps.net.netty.Attributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static io.netty.util.internal.ObjectUtil.checkNotNull;

/**
 *
 */
public class RS2SessionHandler extends ChannelInboundHandlerAdapter {

    /**
     * The logger for this class
     */
    private final Logger logger = LoggerFactory.getLogger(RS2SessionHandler.class);

    /**
     * The session manager
     */
    private final SessionManager manager;

    public RS2SessionHandler(SessionManager manager) {
        this.manager = checkNotNull(manager, "sessionManager");
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        ctx.channel().attr(Attributes.SESSION_ATTRIBUTE_KEY).set(manager.register(new NettyStatefulSession(ctx.channel())));
        logger.debug("session registered " + ctx.channel().remoteAddress());
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        if (ctx.channel().hasAttr(Attributes.SESSION_ATTRIBUTE_KEY)) {
            manager.remove(ctx.channel().attr(Attributes.SESSION_ATTRIBUTE_KEY).get());
        }
        logger.debug("session unregistered " + ctx.channel().remoteAddress());
    }

}
