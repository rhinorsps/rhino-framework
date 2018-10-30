package org.rhino.rsps.net.packet.handler.impl;

import org.rhino.rsps.net.packet.DefaultPacket;
import org.rhino.rsps.net.packet.Packet;
import org.rhino.rsps.net.packet.definition.PacketDefinition;
import org.rhino.rsps.net.stream.InputStream;
import org.rhino.rsps.net.stream.OutputStream;

import java.io.IOException;
import java.nio.BufferUnderflowException;

public class FixedHeaderPacketHandler extends AbstractPacketHandler {

    /**
     *
     */
    public FixedHeaderPacketHandler() {
        super (PacketDefinition.HeaderType.FIXED_SIZE);
    }

    @Override
    public Packet read(PacketDefinition definition, InputStream in) throws IOException {
        if (in.available() < definition.getExpectedLength() + 1)
            throw new BufferUnderflowException();

        int opcode = in.readUnsignedByte();
        if (opcode != definition.getExpectedOpcode())
            throw new IllegalStateException("opcode mismatch [" + opcode + "," + definition.getExpectedOpcode() + "]");

        return new DefaultPacket(opcode, in.readSlice(definition.getExpectedLength()), definition);
    }

    @Override
    public void write(Packet packet, OutputStream out) throws IOException {
        if (out.available() < packet.getDefinition().getExpectedLength() + 1)
            throw new BufferUnderflowException();

        out.writeByte(packet.getOpcode());
        out.write(packet.getPayload());
    }

}
