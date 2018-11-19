package org.rhino.rsps.net;

public interface Server extends AutoCloseable {

    /**
     * Publishes the server
     *
     * @throws Exception
     */
    void publish() throws Exception;

}
