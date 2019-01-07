package org.rhino.rsps.net;

import org.rhino.rsps.core.session.SessionManager;
import org.rhino.rsps.net.packet.PacketDefinitionRepository;

import java.net.InetSocketAddress;

public interface ServerContext {

    /**
     * The host address
     *
     * @return
     */
    InetSocketAddress getHostAddress();

    /**
     * The session manager
     *
     * @return
     */
    SessionManager<?> getSessionManager();

    /**
     * The packet repository
     *
     * @return
     */
    PacketDefinitionRepository getPacketRepository();

}
