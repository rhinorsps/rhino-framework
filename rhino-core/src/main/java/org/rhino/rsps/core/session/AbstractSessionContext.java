package org.rhino.rsps.core.session;

import java.net.InetSocketAddress;
import java.util.concurrent.atomic.AtomicReference;

public abstract class AbstractSessionContext implements SessionContext {

    /**
     * This session's state
     */
    private final AtomicReference<State> state = new AtomicReference<>();

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

    @Override
    public State getState() {
        return this.state.getAcquire();
    }

    @Override
    public State setState(State state) {
        return this.state.getAndSet(state);
    }
}
