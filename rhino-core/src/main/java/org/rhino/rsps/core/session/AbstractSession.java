package org.rhino.rsps.core.session;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public abstract class AbstractSession<CHANNEL> implements Session<CHANNEL> {

    /**
     * The session context
     */
    private final SessionContext context;

    public AbstractSession(SessionContext context) {
        this.context = context;
    }

    @Override
    public SessionContext getContext() {
        return this.context;
    }

    @Override
    public <T> CompletableFuture<T> read(T message) throws IOException {
        return null;
    }

}
