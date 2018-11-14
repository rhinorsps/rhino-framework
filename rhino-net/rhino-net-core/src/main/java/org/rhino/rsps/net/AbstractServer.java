package org.rhino.rsps.net;

import org.rhino.rsps.net.Server;
import org.rhino.rsps.net.ServerContext;

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
