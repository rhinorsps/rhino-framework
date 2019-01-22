package org.rhino.rsps.net.netty.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.rhino.rsps.net.ServerContext;
import org.rhino.rsps.net.packet.Packet;

import java.util.List;

/**
 * The class responsible for turning a packet into an object
 */
public class MarshallingDecoder extends MessageToMessageDecoder<Packet> {

    /**
     * The server context
     */
    private final ServerContext context;

    MarshallingDecoder(ServerContext context) {
        this.context = context;
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, Packet packet, List<Object> list) throws Exception {
        // if the packet has a null identifier, nothing can happen
        if (packet.getIdentifier() == null)
            return;


    }

}
