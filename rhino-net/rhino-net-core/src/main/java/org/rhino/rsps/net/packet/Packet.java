package org.rhino.rsps.net.packet;

import org.rhino.rsps.net.stream.InputStream;

public interface Packet extends Serializable {

    /**
     * The packet's identifier. This contains information in which stage it is expected and what the opcode is.
     *
     * @return
     */
    PacketIdentifier getIdentifier();

    /**
     * Gets the packet's payload
     *
     * @return
     */
    InputStream getPayload();

    /**
     * The packet meta data
     */
    enum MetaData {

        /**
         * Indicates there is no metadata
         */
        EMPTY,

        /**
         * Indicates the length of the packet is stored as an 8-bit integer header
         */
        SMALL,

        /**
         * Indicates the length of the packet is stored as a 16-bit integer in the header
         */
        MEDIUM,

        /**
         * Indicates the length of the packet is stored as a 32-bit integer in the header
         */
        BIG;

    }

}
