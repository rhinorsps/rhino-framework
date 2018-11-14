package org.rhino.rsps.net.session;

import java.net.InetSocketAddress;

public interface SessionContext {

    /**
     *
     * @return
     */
    State state();

    /**
     *
     * @return
     */
    InetSocketAddress address();

    /**
     *
     */
    enum State {
        /**
         * Default state, session has been discovered but no action has been taken as of yet
         */
        DISCOVERED,

        /**
         * The user has authenticated, but has no active game session
         */
        AUTHENTICATED,

        /**
         * The user has authenticated and has an active game session
         */
        ACTIVE,

        /**
         * The user is authenticated, has a game session, but is idle
         */
        IDLE,

        /**
         * The user has been disconnected and its session is interrupted
         */
        DISCONNECTED;
    }

}
