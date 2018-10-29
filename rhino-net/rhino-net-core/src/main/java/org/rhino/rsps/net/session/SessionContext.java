package org.rhino.rsps.net.session;

public interface SessionContext {

    State state();

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
