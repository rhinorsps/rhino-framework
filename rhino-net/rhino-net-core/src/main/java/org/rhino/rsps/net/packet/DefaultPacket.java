package org.rhino.rsps.net.packet;

import org.rhino.rsps.net.packet.definition.PacketDefinition;
import org.rhino.rsps.net.stream.InputStream;

/**
 * FIXME: redundant?
 */
public class DefaultPacket implements Packet {

    private final int opcode;
    private final InputStream payload;
    private final PacketDefinition definition;

    public DefaultPacket(int opcode, InputStream payload, PacketDefinition definition) {
        this.opcode = opcode;
        this.payload = payload;
        this.definition = definition;
    }

    @Override
    public int getOpcode() {
        return opcode;
    }

    @Override
    public InputStream getPayload() {
        return payload;
    }

    @Override
    public PacketDefinition getDefinition() {
        return definition;
    }
}
