package org.rhino.rsps.net;

public interface Server extends AutoCloseable {

    /**
     * Publishes the server
     *
     * @throws Exception
     */
    void publish() throws Exception;

    /**
     * Terminates the server
     *
     * @throws Exception
     */
    void terminate() throws Exception;

    @Override
    default void close() throws Exception {
        this.terminate(); // FIXME
    }

}
