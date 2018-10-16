package org.rhino.rsps.net.io.concurrent;

import java.util.function.Consumer;

public interface Promise<T> {

    /**
     * Adds a new consumer to the
     * @param consumer
     * @return self
     */
    Promise<T> success(Consumer<T> consumer);

    /**
     *
     * @param consumer
     * @return
     */
    Promise<T> error(Consumer<Throwable> consumer);

    /**
     * Called when the promise has failed to execute
     * @return
     */
    void fail(Throwable t);

    /**
     *
     * @param result
     * @return
     */
    void fulfill(T result) throws Exception;

}
