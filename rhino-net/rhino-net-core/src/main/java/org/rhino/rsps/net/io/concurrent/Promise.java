package org.rhino.rsps.net.io.concurrent;

public interface Promise<T> {

    /**
     * Adds a new subscriber to the
     * @param subscriber
     * @return self
     */
    Promise<T> subscribe(Subscriber<T> subscriber);

    /**
     * Removes a subscriber from this promise
     *
     * @param subscriber
     * @throws NullPointerException when the subscriber cannot be found
     * @return self
     */
    Promise<T> remove(Subscriber<T> subscriber);

    /**
     * Cancels the current promise and sends a fail notification to all of the subscribers
     * @return self
     * @throws Exception
     */
    Promise<T> cancel() throws Exception;

}
