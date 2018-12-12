package org.rhino.rsps.net;

import org.rhino.rsps.core.session.SessionManager;

import java.net.InetSocketAddress;

public interface ServerContext {

    /**
     * @return
     */
    InetSocketAddress getHostAddress();

    /**
     * @return
     */
    SessionManager<?> getSessionManager();

}
