package org.rhino.rsps.net.packet.handler;

import org.rhino.rsps.net.packet.DefaultPacket;
import org.rhino.rsps.net.packet.Packet;
import org.rhino.rsps.net.packet.definition.PacketDefinition;
import org.rhino.rsps.net.stream.ByteBufferInputStream;
import org.rhino.rsps.net.stream.InputStream;
import org.rhino.rsps.net.stream.OutputStream;

import java.io.IOException;
import java.nio.BufferUnderflowException;

/**
 * FIXME: This can obviously be made abstract to combine both 8 and 16 bit headers
 */
public class Variable16BitHeaderPacketHandler extends AbstractPacketHandler {

    /**
     *
     */
    public Variable16BitHeaderPacketHandler() {
        super(PacketDefinition.HeaderType.VARIABLE_SIZE_16);
    }

    @Override
    public Packet read(PacketDefinition definition, InputStream in) throws IOException {
        if (in.available() < definition.getExpectedLength() + 3)
            throw new BufferUnderflowException();

        int opcode = in.readUnsignedByte();
        if (opcode != definition.getExpectedOpcode())
            throw new IllegalStateException("opcode mismatch [" + opcode + "," + definition.getExpectedOpcode() + "]");

        return new DefaultPacket(opcode, definition, new ByteBufferInputStream(in.read(in.readUnsignedShort())));
    }

    @Override
    public void write(Packet packet, OutputStream out) throws IOException {
        if (out.available() < packet.getDefinition().getExpectedLength() + 3)
            throw new BufferUnderflowException();

        out.writeByte(packet.getOpcode());
        out.writeShort(packet.getPayload().available());
        out.write(packet.getPayload());
    }
}
