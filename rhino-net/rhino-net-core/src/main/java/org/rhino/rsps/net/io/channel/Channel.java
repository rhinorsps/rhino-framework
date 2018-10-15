package org.rhino.rsps.net.io.channel;

import org.rhino.rsps.net.io.concurrent.Promise;

import java.io.IOException;

public interface Channel {

    /**
     * Gets the current state of this channel
     *
     * @return
     */
    ChannelState getCurrentState();

    /**
     * Attempts to put the message into the outgoing message queue
     *
     * @param object
     * @param <T>
     * @return
     * @throws IOException
     */
    <T> Promise<T> write(T object) throws IOException;

    /**
     * Pushes an object on the incoming message queue
     *
     * @param object
     * @param <T>    The object type that is being read
     * @return a {@link Promise} that will end when the object has been successfully read
     * @throws IOException
     */
    <T> Promise<T> read(T object) throws IOException;

    /**
     * Attempts to close the channel
     *
     * @return
     * @throws IOException
     */
    Promise<?> close() throws IOException;

}
