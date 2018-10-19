package org.rhino.rsps.net.netty.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.rhino.rsps.net.netty.session.NettySession;
import org.rhino.rsps.net.netty.util.Attributes;
import org.rhino.rsps.net.session.Session;
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

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        if (ctx.channel().hasAttr(Attributes.SESSION_ATTRIBUTE_KEY)) {
            Session session = new NettySession(ctx.channel());

            ctx.channel().attr(Attributes.SESSION_ATTRIBUTE_KEY).set(session);
            logger.info("channel registered " + ctx.channel().remoteAddress());
        } else {
            ctx.channel().close();
        }
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        if (ctx.channel().hasAttr(Attributes.SESSION_ATTRIBUTE_KEY)) {
            ctx.channel().attr(Attributes.SESSION_ATTRIBUTE_KEY).get().destroy();
        }
        logger.info("channel unregistered " + ctx.channel().remoteAddress());
    }

}
