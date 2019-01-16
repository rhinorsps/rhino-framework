package org.rhino.rsps.net.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.rhino.rsps.net.ServerContext;
import org.rhino.rsps.net.netty.stream.ByteBufInputStreamProvider;
import org.rhino.rsps.net.packet.Packet;
import org.rhino.rsps.net.packet.PacketDefinition;
import org.rhino.rsps.net.packet.PacketIdentifier;
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

    public PacketDecoder(ServerContext serverContext) {
        this.serverContext = serverContext;
    }

    @Override
    protected void decode(ChannelHandlerContext channelContext, ByteBuf in, List<Object> out) throws Exception {
        PacketIdentifier identifier = this.createIdentifier(channelContext, in.readUnsignedByte());
        PacketDefinition definition = this.serverContext.getPacketRepository().getDecodeDefinition(identifier);

        switch (definition.getMetaData()) {
            case FIXED:
                out.add(this.read(identifier, definition.getLength(), in));
                break;
            case SMALL:
                out.add(this.read(identifier, in.readUnsignedByte(), in));
                break;
            case MEDIUM:
                out.add(this.read(identifier, in.readUnsignedShort(), in));
                break;
            case BIG:
                out.add(this.read(identifier, in.readInt(), in));
                break;
            case AVAILABLE:
                out.add(this.read(identifier, in.readableBytes(), in));
                break;
        }
    }

    private Packet read(PacketIdentifier identifier, int length, ByteBuf in) {

        return null;
    }

    /**
     * Assembles a packet identifier
     *
     * @return
     */
    private PacketIdentifier createIdentifier(ChannelHandlerContext channelContext, int opcode) {
        return null;
    }

}
