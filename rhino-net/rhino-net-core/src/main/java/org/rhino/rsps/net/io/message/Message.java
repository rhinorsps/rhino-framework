package org.rhino.rsps.net.io.message;

import org.rhino.rsps.net.io.stream.InputStream;

import java.io.IOException;

/**
 * A read-only message.
 */
public interface Message {

    /**
     * The opcode of the packet
     *
     * @return
     * @throws IOException
     */
    int getOpcode() throws IOException;

    /**
     * Gets the packet's payload
     *
     * @return
     * @throws IOException thrown when the packet has no payload
     */
    InputStream getPayload() throws IOException;

}
