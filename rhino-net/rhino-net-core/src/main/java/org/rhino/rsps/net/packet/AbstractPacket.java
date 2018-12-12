package org.rhino.rsps.net.packet;

public abstract class AbstractPacket implements Packet {

    private final int opcode;
    private final Payload payload;

    public AbstractPacket(int opcode, Payload payload) {
        this.opcode = opcode;
        this.payload = payload;
    }

    @Override
    public int getOpcode() {
        return this.opcode;
    }

    @Override
    public Payload getPayload() {
        return this.payload;
    }

}
