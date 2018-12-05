package org.rhino.rsps.net.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.rhino.rsps.net.ServerContext;
import org.rhino.rsps.net.packet.Packet;

public class GamePacketEncoder extends MessageToByteEncoder<Packet> {

    /**
     * The server context
     */
    private final ServerContext serverContext;

    public GamePacketEncoder(ServerContext serverContext) {
        this.serverContext = serverContext;
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Packet packet, ByteBuf byteBuf) throws Exception {
        byteBuf.writeByte(packet.getOpcode());
        byteBuf.writeShort(packet.getPayload().available());
        byteBuf.writeBytes(packet.getPayload().array());
    }

}
