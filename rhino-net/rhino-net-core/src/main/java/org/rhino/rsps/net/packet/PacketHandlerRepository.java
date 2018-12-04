package org.rhino.rsps.net.packet;

import org.rhino.rsps.net.packet.handler.InputStreamPacketHandler;
import org.rhino.rsps.net.packet.handler.OutputStreamPacketHandler;
import org.rhino.rsps.net.session.SessionContext;

public interface PacketHandlerRepository {

    /**
     * Gets the handler for the descriptor
     * @param descriptor
     * @return
     */
    InputStreamPacketHandler getInputStreamHandler(PacketDescriptor descriptor);

    /**
     * Gets the handler for the descriptor
     *
     * @param descriptor
     * @return
     */
    OutputStreamPacketHandler getOutputStreamHandler(PacketDescriptor descriptor);

}
