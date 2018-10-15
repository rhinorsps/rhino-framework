package org.rhino.rsps.net.io.message;

import org.rhino.rsps.net.io.channel.Channel;

import java.io.IOException;

/**
 * Represents a raw packet
 */
public interface Message {

    /**
     * Gets the packet's header
     *
     * @return
     * @throws IOException thrown when no header is present
     */
    Header getHeader() throws IOException;

    /**
     * Gets the packet's payload
     *
     * @return
     * @throws IOException thrown when the packet has no payload
     */
    Payload getPayload() throws IOException;

}
