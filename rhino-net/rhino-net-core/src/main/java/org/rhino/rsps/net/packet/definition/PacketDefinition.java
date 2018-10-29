package org.rhino.rsps.net.packet.definition;

public interface PacketDefinition {

    /**
     * Gets the expected length of the packet
     * @return
     */
    int getExpectedLength();

    /**
     * Gets the expected opcode
     * @return
     */
    int getExpectedOpcode();

    /**
     * Gets the type of header for the packet
     * @return
     */
    HeaderType getHeaderType();

    /**
     * The type of the header. Do not change order!
     */
    enum HeaderType {

        /**
         * Header is just the opcode
         */
        FIXED_SIZE,

        /**
         * Header is opcode + 1 byte (ubyte) containing the size of the payload.
         */
        VARIABLE_SIZE_8,

        /**
         * Header is the opcode + 2 bytes (ushort) containing the size of the payload
         */
        VARIABLE_SIZE_16;
    }

}
