package org.rhino.rsps.net.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;
import org.rhino.rsps.net.Controller;
import org.rhino.rsps.net.io.message.Message;
import org.rhino.rsps.net.io.message.MessageTemplate;
import org.rhino.rsps.net.io.message.MessageTemplateRepository;
import org.rhino.rsps.net.netty.util.Attributes;
import org.rhino.rsps.net.session.Session;
import org.rhino.rsps.net.session.SessionContext;

import java.io.IOException;
import java.util.List;

public class RS2GameCodec extends ByteToMessageCodec<Message> {

    /**
     *
     */
    private final Controller controller;

    public RS2GameCodec(Controller controller) {
        this.controller = controller;
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Message message, ByteBuf byteBuf) throws Exception {
        Session session = channelHandlerContext.channel().attr(Attributes.SESSION_ATTRIBUTE_KEY).get();
        MessageTemplateRepository repository = controller.getTemplateRepository(session.getSessionContext());

        if (message.getPayload() == null || message.getPayload().isClosed()) {
            throw new IOException("unreadable message");
        }

        MessageTemplate template = repository.getTemplateOutgoing(message);

    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        Session session = channelHandlerContext.channel().attr(Attributes.SESSION_ATTRIBUTE_KEY).get();
        MessageTemplateRepository repository = controller.getTemplateRepository(session.getSessionContext());

        if (byteBuf.readableBytes() <= 0 || !byteBuf.isReadable()) {
            throw new IOException("unreadable buffer");
        }

        MessageTemplate template = repository.getTemplateIncoming(byteBuf.readUnsignedByte());

    }

}
