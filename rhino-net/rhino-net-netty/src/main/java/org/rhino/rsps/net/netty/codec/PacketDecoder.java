package org.rhino.rsps.net.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.rhino.rsps.net.ServerContext;
import org.rhino.rsps.net.netty.stream.ByteBufInputStreamProvider;
import org.rhino.rsps.net.packet.Packet;
import org.rhino.rsps.net.packet.PacketDefinition;
import org.rhino.rsps.net.packet.PacketIdentifier;
import org.rhino.rsps.net.stream.InputStream;
import org.rhino.rsps.net.stream.provider.InputStreamProvider;

import java.util.List;

public class PacketDecoder extends ByteToMessageDecoder {

    /**
     * The server context
     */
    private final ServerContext serverContext;

    /**
     * The class responsible for creating input streams
     */
    private final InputStreamProvider<ByteBuf> provider = new ByteBufInputStreamProvider();

    PacketDecoder(ServerContext serverContext) {
        this.serverContext = serverContext;
    }

    @Override
    protected void decode(ChannelHandlerContext channelContext, ByteBuf in, List<Object> out) throws Exception {
        PacketIdentifier identifier = this.createIdentifier(channelContext, in.readUnsignedByte());
        PacketDefinition definition = this.serverContext.getPacketRepository().getDecodeDefinition(identifier);

        switch (definition.getMetaData()) {
            case FIXED:
                out.add(constructPacket(identifier, definition.getLength(), provider.provide(in)));
                break;
            case SMALL:
                out.add(constructPacket(identifier, in.readUnsignedByte(), provider.provide(in)));
                break;
            case MEDIUM:
                out.add(constructPacket(identifier, in.readUnsignedShort(), provider.provide(in)));
                break;
            case BIG:
                out.add(constructPacket(identifier, in.readInt(), provider.provide(in)));
                break;
            case AVAILABLE:
                out.add(constructPacket(identifier, in.readableBytes(), provider.provide(in)));
                break;
        }
    }

    /**
     * Constructs a packet from the given parameters
     *
     * @param identifier
     * @param length
     * @param in
     * @return
     */
    private Packet constructPacket(PacketIdentifier identifier, int length, InputStream in) {
        // find a way to construct the packet.. maybe a factory implementation?
        return null;
    }

    /**
     * Assembles a packet identifier
     *
     * @param channelContext
     * @param opcode
     * @return
     */
    private PacketIdentifier createIdentifier(ChannelHandlerContext channelContext, int opcode) {
        // find a way to create an identifier... maybe a factory implementation?
        return null;
    }

}
