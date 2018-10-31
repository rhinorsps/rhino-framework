package org.rhino.rsps.net.packet.definition;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PacketDefinitionTest {

    private static final int TEST_OPCODE = 50;

    @Test
    public void testFixedLength() {
        PacketDefinition definition = new DefaultPacketDefinition(TEST_OPCODE, 1, null);

        assertEquals(TEST_OPCODE, definition.getExpectedOpcode());
        assertEquals(1, definition.getExpectedLength());
        assertEquals(PacketDefinition.HeaderType.FIXED_SIZE, definition.getHeaderType());
    }

    @Test
    public void testVariableLength8Bit() {
        PacketDefinition definition = new DefaultPacketDefinition(TEST_OPCODE, PacketDefinition.HeaderType.VARIABLE_SIZE_8, null);

        assertEquals(TEST_OPCODE, definition.getExpectedOpcode());
        assertEquals(-1, definition.getExpectedLength());
        assertEquals(PacketDefinition.HeaderType.VARIABLE_SIZE_8, definition.getHeaderType());
    }

    @Test
    public void testVariableLength16Bit() {
        PacketDefinition definition = new DefaultPacketDefinition(TEST_OPCODE, PacketDefinition.HeaderType.VARIABLE_SIZE_16, null);

        assertEquals(TEST_OPCODE, definition.getExpectedOpcode());
        assertEquals(-1, definition.getExpectedLength());
        assertEquals(PacketDefinition.HeaderType.VARIABLE_SIZE_16, definition.getHeaderType());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeExpectedLengthFixedHeader() {
        PacketDefinition definition = new DefaultPacketDefinition(TEST_OPCODE, -1, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testVariableSizeWithExpectedLength() {
        PacketDefinition definition = new DefaultPacketDefinition(TEST_OPCODE, 1, PacketDefinition.HeaderType.VARIABLE_SIZE_8, null);
    }

}
