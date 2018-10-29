package org.rhino.rsps.net.packet.handler.impl;

import com.google.common.collect.Sets;
import org.rhino.rsps.net.packet.definition.PacketDefinition;
import org.rhino.rsps.net.packet.handler.PacketHandler;

import java.util.Set;

public abstract class AbstractPacketHandler implements PacketHandler {

    /**
     *
     */
    private final Set<PacketDefinition.HeaderType> acceptedHeaders;

    /**
     *
     * @param acceptedHeaders
     */
    protected AbstractPacketHandler(PacketDefinition.HeaderType... acceptedHeaders) {
        this(Sets.newHashSet(acceptedHeaders));
    }

    /**
     *
     * @param acceptedHeaders
     */
    protected AbstractPacketHandler(Set<PacketDefinition.HeaderType> acceptedHeaders) {
        this.acceptedHeaders = acceptedHeaders;
    }

    @Override
    public boolean accepts(PacketDefinition definition) {
        return this.acceptedHeaders.contains(definition.getHeaderType());
    }
}
