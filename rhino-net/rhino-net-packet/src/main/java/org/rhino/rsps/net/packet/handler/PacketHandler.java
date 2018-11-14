package org.rhino.rsps.net.packet.handler;

import org.rhino.rsps.net.packet.Packet;
import org.rhino.rsps.net.packet.definition.PacketDefinition;
import org.rhino.rsps.net.stream.InputStream;
import org.rhino.rsps.net.stream.OutputStream;

import java.io.IOException;

public interface PacketHandler {

    /**
     * @param definition
     * @return
     */
    boolean accepts(PacketDefinition definition);

    /**
     *
     * @param definition
     * @param in
     * @return
     * @throws IOException
     */
    Packet read(PacketDefinition definition, InputStream in) throws IOException;

    /**
     *
     * @param packet
     * @return
     * @throws IOException
     */
    void write(Packet packet, OutputStream out) throws IOException;

}
