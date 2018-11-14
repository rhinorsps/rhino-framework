package org.rhino.rsps.net.session;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public interface Session {

    CompletableFuture<Session> destroy() throws IOException;

    SessionContext getContext();
}
