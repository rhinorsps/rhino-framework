package org.rhino.rsps.net;

import org.rhino.rsps.net.packet.definition.PacketDefinitionRepository;
import org.rhino.rsps.net.session.SessionManager;

import java.net.InetSocketAddress;

public interface ServerContext {

    /**
     * Gets the host address
     *
     * @return
     */
    InetSocketAddress getHostAddress();

    /**
     * the packet definition repository
     */
    PacketDefinitionRepository getRepository();

    /**
     * The session manager
     * @return
     */
    SessionManager getSessionManager();

}
