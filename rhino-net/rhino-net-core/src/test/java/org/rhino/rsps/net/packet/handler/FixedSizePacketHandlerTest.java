package org.rhino.rsps.net.packet.handler;

import org.junit.Test;
import org.rhino.rsps.net.packet.Packet;
import org.rhino.rsps.net.packet.definition.DefaultPacketDefinition;
import org.rhino.rsps.net.packet.definition.PacketDefinition;
import org.rhino.rsps.net.packet.handler.impl.FixedHeaderPacketReader;
import org.rhino.rsps.net.stream.ByteBufferInputStream;
import org.rhino.rsps.net.stream.InputStream;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FixedSizePacketHandlerTest {

    private static final int TEST_OPCODE = 69;
    private static final int TEST_LENGTH = 4;
    private static final PacketDefinition TEST_DEFINITION = new DefaultPacketDefinition(TEST_OPCODE, TEST_LENGTH);

    private static final FixedHeaderPacketReader TEST_READER = new FixedHeaderPacketReader();

    private static final byte[] TEST_DATA = {
            1, 2, 3, 4
    };

    @Test
    public void testNormalRead() throws IOException {
        Packet packet = TEST_READER.read(TEST_DEFINITION, createPacketData());

        assertEquals(TEST_OPCODE, packet.getOpcode());
        assertEquals(TEST_LENGTH, packet.getPayload().available());
        assertEquals(TEST_DEFINITION, packet.getDefinition());

        assertArrayEquals(TEST_DATA, packet.getPayload().read(TEST_LENGTH));
    }

    @Test(expected = BufferUnderflowException.class)
    public void testReadWithLengthTooHigh() throws IOException {
        PacketDefinition definition = new DefaultPacketDefinition(TEST_OPCODE, TEST_LENGTH + 1);
        TEST_READER.read(definition, createPacketData());
    }

    private InputStream createPacketData() {
        return new ByteBufferInputStream((ByteBuffer) ByteBuffer.allocate(1 + TEST_LENGTH)
                .put((byte) TEST_OPCODE)
                .put(TEST_DATA)
                .flip());
    }

}
