package org.rhino.rsps.net.packet.definition;

public class DefaultPacketDefinition implements PacketDefinition {

    /**
     * The expected packet length
     */
    private final int expectedLength;

    /**
     * The expected opcode of the packet
     */
    private final int expectedOpcode;

    /**
     * The type of header
     */
    private final HeaderType headerType;

    /**
     *
     * @param expectedOpcode
     * @param expectedLength
     */
    public DefaultPacketDefinition(int expectedOpcode, int expectedLength) {
        this(expectedOpcode, expectedLength, HeaderType.FIXED_SIZE);
    }

    /**
     *
     * @param expectedOpcode
     * @param headerType
     */
    public DefaultPacketDefinition(int expectedOpcode, HeaderType headerType) {
        this(expectedOpcode, -1, headerType);
    }

    /**
     *
     * @param expectedOpcode
     * @param expectedLength
     * @param headerType
     */
    public DefaultPacketDefinition(int expectedOpcode, int expectedLength, HeaderType headerType) {
        this.expectedLength = expectedLength;
        this.expectedOpcode = expectedOpcode;
        this.headerType = headerType;
    }

    @Override
    public int getExpectedLength() {
        return expectedLength;
    }

    @Override
    public int getExpectedOpcode() {
        return expectedOpcode;
    }

    @Override
    public HeaderType getHeaderType() {
        return headerType;
    }
}
