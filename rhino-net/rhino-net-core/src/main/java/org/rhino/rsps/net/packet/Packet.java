package org.rhino.rsps.net.packet;

import org.rhino.rsps.net.stream.InputStream;
import org.rhino.rsps.net.stream.OutputStream;

public interface Packet {

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
     * Serializes the packet to the output stream
     *
     * @return
     */
    void serialize(OutputStream out);

    /**
     * The packet meta data
     */
    enum MetaData {

        /**
         * Indicates there is no metadata
         */
        EMPTY,

        /**
         * Indicates the length of the packet is stored as a byte header
         */
        SMALL,

        /**
         * Indicates the length of the packet is stored as a short in the header
         */
        BIG;

    }

}
