package org.rhino.rsps.net;

public abstract class AbstractServer implements Server {

    /**
     * The controller's context
     */
    private final ServerContext context;

    public AbstractServer(ServerContext context) {
        this.context = context;
    }

    @Override
    public ServerContext getServerContext() {
        return context;
    }

}
