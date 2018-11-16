package org.rhino.rsps.net.session;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.CompletableFuture;

public interface SessionManager {

    /**
     *
     * @param address
     * @return
     * @throws Exception
     */
    Session create(InetSocketAddress address) throws Exception;

    /**
     *
     * @param session
     * @throws Exception
     */
    void register(Session session) throws Exception;

    /**
     *
     * @param session
     * @throws Exception
     */
    void unregister(Session session) throws Exception;

    /**
     *
     * @param session
     * @return
     * @throws Exception
     */
    CompletableFuture<?> destroy(Session session) throws Exception;

    /**
     *
     * @param address
     * @return
     * @throws Exception
     */
    default Session createAndRegister(InetSocketAddress address) throws Exception {
        Session session = this.create(address);
        this.register(session);
        return session;
    }

}
