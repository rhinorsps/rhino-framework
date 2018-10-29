package org.rhino.rsps.net.packet.handler.impl;

import org.rhino.rsps.net.packet.DefaultPacket;
import org.rhino.rsps.net.packet.Packet;
import org.rhino.rsps.net.packet.definition.PacketDefinition;
import org.rhino.rsps.net.session.SessionContext;
import org.rhino.rsps.net.stream.InputStream;
import org.rhino.rsps.net.stream.OutputStream;

import java.io.IOException;
import java.nio.BufferUnderflowException;

/**
 * FIXME: This can obviously be made abstract to combine both 8 and 16 bit headers
 */
public class Variable16BitHeaderPacketReader extends AbstractPacketHandler {

    /**
     *
     */
    public Variable16BitHeaderPacketReader() {
        super(PacketDefinition.HeaderType.VARIABLE_SIZE_16);
    }

    @Override
    public Packet read(PacketDefinition definition, InputStream in) throws IOException {
        if (in.available() < definition.getExpectedLength() + 3)
            throw new BufferUnderflowException();

        return new DefaultPacket(in.readUnsignedByte(), in.readSlice(in.readUnsignedShort()), definition);
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
