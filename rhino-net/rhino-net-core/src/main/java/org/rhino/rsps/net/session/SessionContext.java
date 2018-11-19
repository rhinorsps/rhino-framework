package org.rhino.rsps.net.session;

import java.net.InetSocketAddress;

public interface SessionContext {

    /**
     * Gets the session manager for this context
     *
     * @return
     */
    SessionManager getSessionManager();

    /**
     * The address of the session
     *
     * @return
     */
    InetSocketAddress getRemoteAddress();

    /**
     *
     * @return
     */
    State getState();

    /**
     *
     * @param state
     * @return
     */
    State setState(State state);

    /**
     * The state of the connection
     */
    enum State {
        CONNECTED, AUTHENTICATED, ACTIVE, IDLE, DISCONNECTED;
    }

}
