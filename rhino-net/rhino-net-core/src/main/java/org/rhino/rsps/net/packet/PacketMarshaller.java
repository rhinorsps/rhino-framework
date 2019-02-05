package org.rhino.rsps.net.packet;

public interface PacketMarshaller {

    /**
     *
     * @param packet
     * @return
     * @throws Exception
     */
    Object unmarshal(Packet packet) throws Exception;

    /**
     *
     * @param object
     * @return
     * @throws Exception
     */
    Packet marshal(Object object) throws Exception;

}
