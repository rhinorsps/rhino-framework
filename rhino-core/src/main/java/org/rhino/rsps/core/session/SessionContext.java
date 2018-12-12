package org.rhino.rsps.core.session;

import java.net.InetSocketAddress;

public interface SessionContext {

    /**
     * Gets the session manager for this context
     *
     * @return
     */
    SessionManager<?> getSessionManager();

    /**
     * The address of the session
     *
     * @return
     */
    InetSocketAddress getRemoteAddress();

}
