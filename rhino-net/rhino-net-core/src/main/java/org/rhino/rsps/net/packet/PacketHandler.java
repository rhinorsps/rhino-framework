package org.rhino.rsps.net.packet;

import org.rhino.rsps.net.session.SessionContext;

public interface PacketHandler<I, O> {

    /**
     *
     * @param input
     * @param descriptor
     * @param context
     * @return
     * @throws Exception
     */
    O handlePacket(I input, PacketDescriptor descriptor, SessionContext context) throws Exception;

}
