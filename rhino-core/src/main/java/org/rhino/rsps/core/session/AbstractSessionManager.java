package org.rhino.rsps.core.session;

import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public abstract class AbstractSessionManager<CHANNEL> implements SessionManager<CHANNEL> {

    /**
     * The collection of registered sessions
     */
    private final Set<Session<CHANNEL>> registeredSessions = new HashSet<>();

    @Override
    public void register(Session<CHANNEL> session) throws Exception {
        this.registeredSessions.add(session);
    }

    @Override
    public void unregister(Session<CHANNEL> session) throws Exception {
        this.registeredSessions.remove(session);
    }

    @Override
    public CompletableFuture<?> destroy(Session<CHANNEL> session) throws Exception {
        return session.destroy();
    }

    protected Set<Session<CHANNEL>> retrieveAll() {
        return this.registeredSessions;
    }

}
