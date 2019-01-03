package org.rhino.rsps.net.packet;

/**
 * The state of authentication
 */
public enum ConnectionState {

    /**
     *
     */
    HANDSHAKE,

    /**
     * The authentication
     */
    AUTHENTICATION,

    /**
     * Game packet definitions are stored in the packet repository
     */
    GAME;

}