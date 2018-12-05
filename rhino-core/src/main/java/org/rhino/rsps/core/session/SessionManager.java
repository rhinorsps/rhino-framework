package org.rhino.rsps.core.session;

import java.net.InetSocketAddress;
import java.util.concurrent.CompletableFuture;

public interface SessionManager<CHANNEL> {

    /**
     *
     * @param address
     * @return
     * @throws Exception
     */
    Session create(InetSocketAddress address, CHANNEL channel) throws Exception;

    /**
     *
     * @param session
     * @throws Exception
     */
    void register(Session<CHANNEL> session) throws Exception;

    /**
     *
     * @param session
     * @throws Exception
     */
    void unregister(Session<CHANNEL> session) throws Exception;

    /**
     *
     * @param session
     * @return
     * @throws Exception
     */
    CompletableFuture<?> destroy(Session<CHANNEL> session) throws Exception;

    /**
     *
     * @param address
     * @return
     * @throws Exception
     */
    default Session createAndRegister(InetSocketAddress address, CHANNEL channel) throws Exception {
        Session session = this.create(address, channel);
        this.register(session);
        return session;
    }

}
