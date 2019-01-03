package org.rhino.rsps.net.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.rhino.rsps.net.ServerContext;
import org.rhino.rsps.net.packet.Packet;

public class PacketEncoder extends MessageToByteEncoder<Packet> {

    /**
     * The server context
     */
    private final ServerContext serverContext;

    /**
     *
     * @param serverContext
     */
    public PacketEncoder(ServerContext serverContext) {
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