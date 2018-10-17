package org.rhino.rsps.net.session;

import org.rhino.rsps.net.Controller;

import java.util.concurrent.atomic.AtomicReference;

public abstract class RS2Session implements Session {

    /**
     * The session context
     */
    private final AtomicReference<SessionContext> context = new AtomicReference<>();

    /**
     *
     */
    protected final Controller controller;

    public RS2Session(Controller controller) {
        this.controller = controller;
    }

    @Override
    public SessionContext getSessionContext() {
        return this.context.get();
    }

    public void setSessionContext(SessionContext context) {
        this.context.set(context);
    }

}
