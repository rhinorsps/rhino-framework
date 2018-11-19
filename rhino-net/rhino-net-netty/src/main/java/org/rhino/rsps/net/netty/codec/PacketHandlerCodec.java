package org.rhino.rsps.net.netty.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import org.rhino.rsps.net.netty.Attributes;
import org.rhino.rsps.net.packet.Packet;
import org.rhino.rsps.net.packet.PacketDescriptor;
import org.rhino.rsps.net.packet.PacketHandler;
import org.rhino.rsps.net.packet.PacketRepository;
import org.rhino.rsps.net.packet.handler.InputStreamPacketHandler;
import org.rhino.rsps.net.session.Session;

import java.util.List;

public class PacketHandlerCodec extends MessageToMessageCodec<Packet, Object> {

    /**
     *
     */
    private final PacketRepository repository;

    public PacketHandlerCodec(PacketRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, Object in, List<Object> out) throws Exception {
        Session session = ctx.channel().attr(Attributes.SESSION).get();
        PacketDescriptor descriptor = this.repository.getOutputStreamDescriptor(in.getClass(), session.getContext());
        PacketHandler<Object, Packet> packetHandler = this.repository.getOutputStreamHandler(descriptor, session.getContext());

        out.add(packetHandler.handlePacket(in, descriptor, session.getContext()));
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, Packet packet, List<Object> out) throws Exception {
        Session session = ctx.channel().attr(Attributes.SESSION).get();
        PacketHandler<Packet, Object> packetHandler = repository.getInputStreamHandler(packet.getDescriptor(), session.getContext());

        out.add(packetHandler.handlePacket(packet, packet.getDescriptor(), session.getContext()));
    }

}
