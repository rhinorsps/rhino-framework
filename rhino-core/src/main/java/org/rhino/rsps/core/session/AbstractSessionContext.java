package org.rhino.rsps.core.session;

import java.net.InetSocketAddress;

public abstract class AbstractSessionContext implements SessionContext {

    /**
     * The remote address of the session
     */
    private final InetSocketAddress address;

    /**
     * The session for this context's manager
     */
    private final SessionManager<?> manager;

    public AbstractSessionContext(InetSocketAddress address, SessionManager<?> manager) {
        this.address = address;
        this.manager = manager;
    }

    @Override
    public SessionManager<?> getSessionManager() {
        return this.manager;
    }

    @Override
    public InetSocketAddress getRemoteAddress() {
        return this.address;
    }

}
