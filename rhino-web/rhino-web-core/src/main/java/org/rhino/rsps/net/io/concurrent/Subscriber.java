package org.rhino.rsps.net.io.concurrent;

/**
 * @param <T>
 */
public interface Subscriber<T> {

    /**
     * method for handling errors caught during the execution of success
     *
     * @param t
     * @return
     * @throws Exception when errors occur during the execution of the error handling (lol), networking service should
     *                   be stopped, as it means something is seriously wrong
     */
    Subscriber<T> error(Throwable t) throws Exception;

    /**
     * Called when the promise failed to execute successfully
     *
     * @param t
     * @return
     * @throws Exception
     */
    Subscriber<T> fail(Throwable t) throws Exception;

    /**
     * Called when the promise has finished successfully
     *
     * @param event
     * @return
     * @throws Exception
     */
    Subscriber<T> success(T event) throws Exception;

}
