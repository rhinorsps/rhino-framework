package org.rhino.rsps.net.packet.definition;

import org.rhino.rsps.net.packet.handler.PacketHandler;

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
     */
    private final PacketHandler handler;

    /**
     *
     * @param expectedOpcode
     * @param expectedLength
     */
    public DefaultPacketDefinition(int expectedOpcode, int expectedLength, PacketHandler handler) {
        this(expectedOpcode, expectedLength, HeaderType.FIXED_SIZE, handler);
    }

    /**
     *
     * @param expectedOpcode
     * @param headerType
     */
    public DefaultPacketDefinition(int expectedOpcode, HeaderType headerType, PacketHandler handler) {
        this(expectedOpcode, -1, headerType, handler);
    }

    /**
     *
     * @param expectedOpcode
     * @param expectedLength
     * @param headerType
     */
    public DefaultPacketDefinition(int expectedOpcode, int expectedLength, HeaderType headerType, PacketHandler handler) {
        if (expectedLength >= 0 && headerType != HeaderType.FIXED_SIZE)
            throw new IllegalArgumentException("expected length cannot be >= 0 without fixed header type");
        if (expectedLength < 0 && headerType == HeaderType.FIXED_SIZE)
            throw new IllegalArgumentException("fixed header type needs expected length >= 0");

        this.expectedLength = expectedLength;
        this.expectedOpcode = expectedOpcode;
        this.headerType = headerType;
        this.handler = handler;
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

    @Override
    public PacketHandler getHandler() {
        return handler;
    }
}
