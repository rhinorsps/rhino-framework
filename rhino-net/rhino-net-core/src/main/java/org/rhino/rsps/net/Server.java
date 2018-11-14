package org.rhino.rsps.net;

import java.net.InetSocketAddress;

public interface Server {

    /**
     * @throws Exception
     */
    void serve() throws Exception;

    /**
     * Shuts the service down
     *
     * @throws Exception
     */
    void shutdown() throws Exception;

    /**
     *
     * @return
     */
    ServerContext getServerContext();

}
