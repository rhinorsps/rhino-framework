package org.rhino.rsps.net.session;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public interface Session<CHANNEL> {

    /**
     * Gets the session context
     *
     * @return
     */
    SessionContext getContext();

    /**
     * Marks a message ready for reading
     *
     * @param message
     * @param <T>
     * @return
     * @throws IOException
     */
    <T> CompletableFuture<T> read(T message) throws IOException;

    /**
     * Marks a message ready for writing
     * @param message
     * @param <T>
     * @return
     * @throws IOException
     */
    <T> CompletableFuture<T> write(T message) throws IOException;

    /**
     * Flush the connection
     *
     * @throws IOException
     */
    void flush() throws IOException;

    /**
     * Safely disconnects the session
     *
     * @throws IOException
     */
    CompletableFuture<?> disconnect() throws IOException;

    /**
     * Destroys the session (regardless of safe/unsafe disconnect)
     *
     * @throws IOException
     */
    CompletableFuture<?> destroy() throws IOException;

}
