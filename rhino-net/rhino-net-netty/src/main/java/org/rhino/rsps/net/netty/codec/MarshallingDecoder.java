package org.rhino.rsps.net.netty.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.rhino.rsps.net.ServerContext;
import org.rhino.rsps.net.packet.Packet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * The class responsible for turning a packet into an object
 */
public class MarshallingDecoder extends MessageToMessageDecoder<Packet> {

    /**
     * The logger for this class
     */
    private final Logger logger = LoggerFactory.getLogger(MarshallingDecoder.class);

    /**
     * The server context
     */
    private final ServerContext context;

    MarshallingDecoder(ServerContext context) {
        this.context = context;
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, Packet packet, List<Object> out) throws Exception {
        // if the packet has a null identifier, nothing can happen
        if (packet.getIdentifier() == null)
            return;

        if (this.context.getMarshaller() == null) {
            logger.warn("no marshaller found for session {}", channelHandlerContext.channel().remoteAddress());
            out.add(packet);
        }
        else {
            out.add(this.context.getMarshaller().unmarshal(packet));
        }
    }

}
