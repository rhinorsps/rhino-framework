package org.rhino.rsps.net.packet;

import org.rhino.rsps.net.stream.InputStream;

/**
 * A very simple packet implementation
 */
public class UnmodifiablePacket implements Packet {

    private final int opcode;
    private final InputStream payload;

    public UnmodifiablePacket(int opcode, InputStream payload) {
        this.opcode = opcode;
        this.payload = payload;
    }

    @Override
    public InputStream getPayload() {
        return this.payload;
    }

    @Override
    public int getOpcode() {
        return this.opcode;
    }

}
