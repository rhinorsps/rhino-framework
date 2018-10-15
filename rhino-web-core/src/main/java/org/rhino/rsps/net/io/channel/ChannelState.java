package org.rhino.rsps.net.io.channel;

public enum ChannelState {

    /**
     * Indicates the channel is able to perform read/write operations
     */
    OPEN,

    /**
     * Indicates the channel is closed by the server
     */
    CLOSED,

    /**
     * Indicates the channel has been closed by the client
     */
    DISCONNECTED;

}
