package org.rhino.rsps.net.io;

import org.rhino.rsps.net.io.channel.Channel;

import java.io.IOException;

/**
 * Seeing as how we don't know where the output stream comes from, we have to let the factory decide which
 * output streams are created. This depends on the implementation (e.g. JBoss Netty will have a different
 * output stream than Grizzly, as they use different underlying data buffers).
 */
public interface OutputStreamFactory {

    /**
     * Creates a default {@link OutputStream}. Used for when the length of data that needs to be written is unknown.
     *
     * @return
     * @throws Exception
     */
    OutputStream createOutputStream() throws IOException;

    /**
     * Creates an {@link OutputStream} with a given amount of data available to be written.
     *
     * @param length
     * @return
     */
    OutputStream createOutputStream(int length) throws IOException;

    /**
     * Create an {@link OutputStream} bound to a channel.
     *
     * @param length
     * @param channel
     * @return
     */
    BoundOutputStream createBoundOutputStream(int length, Channel channel);

}
