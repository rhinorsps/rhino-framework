package org.rhino.rsps.net.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.rhino.rsps.net.ServerContext;
import org.rhino.rsps.net.netty.stream.ByteBufOutputStreamProvider;
import org.rhino.rsps.net.packet.Packet;
import org.rhino.rsps.net.stream.provider.OutputStreamProvider;

public class PacketEncoder extends MessageToByteEncoder<Packet> {

    /**
     * The output stream provider
     */
    private final OutputStreamProvider<ByteBuf> outputStreamProvider = new ByteBufOutputStreamProvider();

    /**
     * The server context
     */
    private final ServerContext serverContext;

    /**
     *
     * @param serverContext
     */
    PacketEncoder(ServerContext serverContext) {
        this.serverContext = serverContext;
    }

    /**
     *
     * @param ctx
     * @param packet
     * @param out
     * @throws Exception
     */
    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, ByteBuf out) throws Exception {

    }

}