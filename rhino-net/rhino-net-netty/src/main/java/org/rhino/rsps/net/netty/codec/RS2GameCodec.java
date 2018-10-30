package org.rhino.rsps.net.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;
import org.rhino.rsps.net.netty.stream.ByteBufInputStream;
import org.rhino.rsps.net.netty.stream.ByteBufOutputStream;
import org.rhino.rsps.net.netty.util.Attributes;
import org.rhino.rsps.net.packet.Packet;
import org.rhino.rsps.net.packet.definition.PacketDefinition;
import org.rhino.rsps.net.packet.definition.PacketDefinitionRepository;
import org.rhino.rsps.net.session.Session;

import java.io.IOException;
import java.util.List;

public class RS2GameCodec extends ByteToMessageCodec<Packet> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Packet message, ByteBuf byteBuf) throws Exception {
        if (message.getPayload() == null || message.getPayload().isClosed())
            throw new IOException("unreadable message");

        controller.getPacketHandler(message.getDefinition()).write(message, new ByteBufOutputStream(byteBuf));
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> out) throws Exception {
        if (byteBuf.readableBytes() <= 0 || !byteBuf.isReadable())
            throw new IOException("unreadable buffer");

        Session session = channelHandlerContext.channel().attr(Attributes.SESSION_ATTRIBUTE_KEY).get();
        PacketDefinition definition = controller.getDefinition(byteBuf.getByte(0), session.getSessionContext(), PacketDefinitionRepository.SubRepository.DOWNSTREAM);
        out.add(controller.getPacketHandler(definition).read(definition,  new ByteBufInputStream(byteBuf)));
    }

}
