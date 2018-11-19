package org.rhino.rsps.net.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;
import org.rhino.rsps.net.netty.Attributes;
import org.rhino.rsps.net.netty.stream.ByteBufInputStream;
import org.rhino.rsps.net.packet.Packet;
import org.rhino.rsps.net.packet.PacketDescriptor;
import org.rhino.rsps.net.packet.PacketRepository;
import org.rhino.rsps.net.packet.SimplePacket;
import org.rhino.rsps.net.session.Session;

import java.util.List;

public class PacketCodec extends ByteToMessageCodec<Packet> {

    /**
     *
     */
    private final PacketRepository repository;

    public PacketCodec(PacketRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void encode(ChannelHandlerContext context, Packet packet, ByteBuf out) throws Exception {
        out.writeBytes(packet.getPayload().array());
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        Session session = ctx.channel().attr(Attributes.SESSION).get();

        int opcode = in.readUnsignedByte();
        PacketDescriptor descriptor = repository.getInputStreamDescriptor(opcode, session.getContext());
        out.add(new SimplePacket(new ByteBufInputStream(in.readBytes(getLength(in, descriptor))), descriptor));
    }

    /**
     * Gets the length of the packet
     *
     * @param descriptor
     * @param in
     * @return
     */
    private int getLength(ByteBuf in, PacketDescriptor descriptor) {
        switch (descriptor.getHeader()) {
            case FIXED:
                return descriptor.getExpectedLength();
            case VARIABLE_8_BIT:
                return in.readUnsignedByte();
            case VARIABLE_16_BIT:
                return in.readUnsignedShort();
            default:
                throw new IllegalStateException("unrecognized packet header");
        }
    }

}
