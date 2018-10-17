package org.rhino.rsps.net.session;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public interface Session {

    /**
     *
     * @return
     */
    CompletableFuture<Session> destroy() throws IOException;

}
