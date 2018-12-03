package org.rhino.rsps.net;

public interface Server<T> extends AutoCloseable {

    /**
     * Publishes the server
     *
     * @throws Exception
     */
    T publish() throws Exception;

}
