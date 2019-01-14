package org.rhino.rsps.net.packet;

/**
 * Indicates the state the connection is in
 */
public enum State {

    /**
     * The handshake state
     */
    HANDSHAKE,

    /**
     * The authentication state
     */
    AUTHENTICATION,

    /**
     * The state when transferring worlds
     */
    WORLD_ACKNOWLEDGE,

    /**
     * The state when the user is in the lobby
     */
    LOBBY;

}
