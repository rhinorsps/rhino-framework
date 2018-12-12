package org.rhino.rsps.net.packet;

import org.rhino.rsps.net.stream.InputStream;

public interface Payload extends InputStream {

    /**
     * The expected length
     * @return
     */
    int getExpectedLength();

}
