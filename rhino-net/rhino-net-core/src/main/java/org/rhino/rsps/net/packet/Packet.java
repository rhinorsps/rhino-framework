package org.rhino.rsps.net.packet;

import org.rhino.rsps.net.stream.InputStream;

public interface Packet {

    /**
     *
     * @return
     */
    int getOpcode();

    /**
     *
     * @return
     */
    InputStream getPayload();

}
