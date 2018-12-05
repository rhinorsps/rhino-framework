package org.rhino.rsps.net.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import org.rhino.rsps.net.ServerContext;
import org.rhino.rsps.net.netty.stream.ByteBufInputStream;
import org.rhino.rsps.net.packet.UnmodifiablePacket;

import java.util.List;

public class GamePacketDecoder extends ReplayingDecoder {

    /**
     * The packet
     */
    private final ServerContext context;

    public GamePacketDecoder(ServerContext context) {
        this.context = context;
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        int opcode = in.readUnsignedByte();
        int length = in.readUnsignedByte();

        out.add(new UnmodifiablePacket(opcode, new ByteBufInputStream(in.readBytes(length))));
    }

}
