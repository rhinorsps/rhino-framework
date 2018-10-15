package org.rhino.rsps.net.io;

import org.rhino.rsps.net.io.channel.Channel;

/**
 * output streams which are bound to a channel
 */
public interface BoundOutputStream extends OutputStream {

    /**
     *
     * @return
     */
    Channel getChannel();

    /**
     *
     * @return
     */
    OutputStream unbind() throws Exception;

}
