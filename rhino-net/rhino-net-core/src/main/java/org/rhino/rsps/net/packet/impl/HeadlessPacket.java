package org.rhino.rsps.net.packet.impl;

import org.rhino.rsps.net.packet.Packet;
import org.rhino.rsps.net.packet.PacketIdentifier;
import org.rhino.rsps.net.stream.InputStream;

/**
 * A packet that contains only a payload
 */
public class HeadlessPacket implements Packet {

    /**
     *
     */
    private final InputStream payload;

    /**
     *
     * @param payload
     */
    public HeadlessPacket(InputStream payload) {
        this.payload = payload;
    }

    @Override
    public PacketIdentifier getIdentifier() {
        return null;
    }

    @Override
    public InputStream getPayload() {
        return this.payload;
    }

}
