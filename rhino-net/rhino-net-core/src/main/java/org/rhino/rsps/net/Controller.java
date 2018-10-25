package org.rhino.rsps.net;

import java.net.InetSocketAddress;

public interface Controller {

    /**
     * @param address
     * @throws Exception
     */
    void serve(InetSocketAddress address) throws Exception;

    /**
     * Shuts the service down
     *
     * @throws Exception
     */
    void shutdown() throws Exception;

}
