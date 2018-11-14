package org.rhino.rsps.net.netty.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.rhino.rsps.net.netty.NettySession;
import org.rhino.rsps.net.netty.Attributes;
import org.rhino.rsps.net.session.SessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        this.manager = manager;
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        ctx.channel().attr(Attributes.SESSION_ATTRIBUTE_KEY).set(new NettySession(ctx.channel()));
        logger.info("channel registered " + ctx.channel().remoteAddress());
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        if (ctx.channel().hasAttr(Attributes.SESSION_ATTRIBUTE_KEY)) {
            ctx.channel().attr(Attributes.SESSION_ATTRIBUTE_KEY).get().destroy();
        }
        logger.info("channel unregistered " + ctx.channel().remoteAddress());
    }

}
