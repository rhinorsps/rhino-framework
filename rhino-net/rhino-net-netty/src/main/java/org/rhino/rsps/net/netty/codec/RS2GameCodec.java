package org.rhino.rsps.net.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;
import org.rhino.rsps.net.Controller;
import org.rhino.rsps.net.io.message.*;
import org.rhino.rsps.net.io.message.impl.FixedSizeMessageTemplate;
import org.rhino.rsps.net.netty.message.NettyMessageReader;
import org.rhino.rsps.net.netty.message.NettyMessageWriter;
import org.rhino.rsps.net.netty.util.Attributes;
import org.rhino.rsps.net.session.Session;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;

public class RS2GameCodec extends ByteToMessageCodec<Message> {

    /**
     * the controller containing the template repository
     */
    private final Controller controller;

    public RS2GameCodec(Controller controller) {
        this.controller = controller;
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Message message, ByteBuf byteBuf) throws Exception {
        if (message.getPayload() == null || message.getPayload().isClosed())
            throw new IOException("unreadable message");

        Session session = channelHandlerContext.channel().attr(Attributes.SESSION_ATTRIBUTE_KEY).get();
        MessageTemplateRepository repository = controller.getTemplateRepository(session.getSessionContext());
        MessageTemplate template = repository.getTemplateOutgoing(message);
        byteBuf.writeBytes(NettyMessageWriter.create(channelHandlerContext.alloc().buffer())
                .opcode(template.getExpectedOpcode())
                .length(template.getType(), message.getPayload().available())
                .payload(message.getPayload())
                .complete());
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> out) throws Exception {
        if (byteBuf.readableBytes() <= 0 || !byteBuf.isReadable())
            throw new IOException("unreadable buffer");

        Session session = channelHandlerContext.channel().attr(Attributes.SESSION_ATTRIBUTE_KEY).get();
        MessageTemplateRepository repository = controller.getTemplateRepository(session.getSessionContext());
        MessageTemplate template = repository.getTemplateIncoming(byteBuf.getUnsignedByte(0));
        out.add(NettyMessageReader.create(byteBuf)
                .opcode(template.getExpectedOpcode())
                .length(template.getType(), template.getExpectedLength())
                .complete());
    }

}
