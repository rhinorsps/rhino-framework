package org.rhino.rsps.net.packet;


import org.rhino.rsps.net.stream.InputStream;

public interface Packet {

    /**
     * The packet's payload
     * @return
     */
    InputStream getPayload();

    /**
     * The packet's descriptor
     *
     * @return
     */
    PacketDescriptor getDescriptor();

}
