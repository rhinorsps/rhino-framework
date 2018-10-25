package org.rhino.rsps.net.session;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public interface Session {

    /**
     * @return
     */
    CompletableFuture<Session> destroy() throws IOException;

    /**
     * Gets the session context
     *
     * @return
     */
    SessionContext getSessionContext();

}
