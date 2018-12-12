package org.rhino.rsps.net.netty.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import org.rhino.rsps.net.ServerContext;
import org.rhino.rsps.net.packet.Packet;

import java.util.List;

/**
 * Marshals an object into a packet
 */
public class MarshallingEncoder extends MessageToMessageEncoder<Packet> {

    /**
     *
     */
    private final ServerContext context;

    public MarshallingEncoder(ServerContext context) {
        this.context = context;
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Packet packet, List<Object> list) throws Exception {

    }

}
