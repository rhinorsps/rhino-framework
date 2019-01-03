package org.rhino.rsps.net.packet.impl;

import org.rhino.rsps.net.packet.Packet;
import org.rhino.rsps.net.packet.PacketIdentifier;
import org.rhino.rsps.net.stream.InputStream;
import org.rhino.rsps.net.stream.OutputStream;

import java.io.IOException;

public abstract class AbstractPacket implements Packet {

    /**
     * The packet identifier
     */
    private final PacketIdentifier identifier;

    /**
     * The packet payload
     */
    private final InputStream payload;

    public AbstractPacket(PacketIdentifier identifier, InputStream payload) {
        this.identifier = identifier;
        this.payload = payload;
    }

    @Override
    public PacketIdentifier getIdentifier() {
        return this.identifier;
    }

    @Override
    public InputStream getPayload() {
        return this.payload;
    }

}
