package org.rhino.rsps.net.packet;

import org.rhino.rsps.net.Serializable;
import org.rhino.rsps.net.stream.InputStream;

/**
 * Represents a single message between the client and the server.
 * <p>
 * Packets have an identifier, a length and a payload. There are various types of packets which
 * determine how the size of the packet is stored.
 * <p>
 * There are currently 2 known ways in which the game packets can be received.
 * <p>
 * When the size of the packet is a fixed length and is known beforehand:
 * <p>
 * +-------------------+
 * | opcode (byte)     |
 * +-------------------+
 * | payload           |
 * +-------------------+
 * <p>
 * When the size of the packet is received with size varying on the contents, the size is
 * then sent in the header of the message (this can be a short or a byte)
 * <p>
 * +-------------------+
 * | opcode  (byte)    |
 * | length  (various) |
 * +-------------------+
 * | payload           |
 * +-------------------+
 * <p>
 * This length indicator can be either a byte or a short.
 * The type of packet should be known beforehand and is looked up in the repository, it will indicate if it
 * has a fixed length or if it is given, will indicate if the packet is read during the authentication state, etc.
 * <p>
 * This should be configured in the server context (or with annotations if one uses the bootstrap)
 */
public interface Packet {

    /**
     * The packet's identifier
     *
     * @return
     */
    PacketIdentifier getIdentifier();

    /**
     * The packet's length
     *
     * @return
     */
    int getLength();

    /**
     * The packet's meta data
     *
     * @return
     */
    MetaData getMetaData();

    /**
     * The packet's payload
     *
     * @return
     */
    InputStream getPayload();


}
