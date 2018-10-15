package org.rhino.rsps.net.io.channel;

import org.rhino.rsps.net.io.OutputStreamFactory;

/**
 * The channel context is the context in which the channel is made. A channel can have more than one context
 * and it can be shared among multiple channels.
 *
 * Do not store attributes that are bound to a single channel.
 */
public interface ChannelContext {

    /**
     * Gets the {@link OutputStreamFactory} factory
     * @return
     */
    OutputStreamFactory getOutputStreamFactory();

}
