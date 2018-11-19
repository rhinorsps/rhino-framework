package org.rhino.rsps.net.netty.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import org.rhino.rsps.net.packet.Packet;
import org.rhino.rsps.net.packet.PacketDescriptor;
import org.rhino.rsps.net.packet.PacketHandler;
import org.rhino.rsps.net.packet.PacketRepository;
import org.rhino.rsps.net.packet.handler.InputStreamPacketHandler;

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
    protected void encode(ChannelHandlerContext channelHandlerContext, Object in, List<Object> out) throws Exception {
        PacketDescriptor descriptor = this.repository.getOutputStreamDescriptor(in.getClass(), null);
        PacketHandler<Object, Packet> packetHandler = this.repository.getOutputStreamHandler(descriptor, null);

        out.add(packetHandler.handlePacket(in, descriptor, null));
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, Packet packet, List<Object> out) throws Exception {
        PacketHandler<Packet, Object> packetHandler = repository.getInputStreamHandler(packet.getDescriptor(), null);

        out.add(packetHandler.handlePacket(packet, packet.getDescriptor(), null));
    }

}
