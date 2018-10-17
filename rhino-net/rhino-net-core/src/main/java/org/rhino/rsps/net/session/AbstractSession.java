package org.rhino.rsps.net.session;

public abstract class AbstractSession implements Session {

    private final SessionContext sessionContext;

    public AbstractSession(SessionContext sessionContext) {
        this.sessionContext = sessionContext;
    }

    public AbstractSession() {
        this.sessionContext = new DefaultSessionContext();
    }

    @Override
    public SessionContext getSessionContext() {
        return sessionContext;
    }

}
