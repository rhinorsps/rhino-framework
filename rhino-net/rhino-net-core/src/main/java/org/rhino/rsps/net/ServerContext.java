package org.rhino.rsps.net;

import org.rhino.rsps.core.session.SessionManager;
import org.rhino.rsps.net.packet.repository.StatefulPacketRepository;

import java.net.InetSocketAddress;

public interface ServerContext {

    /**
     * @return
     */
    InetSocketAddress getHostAddress();

    /**
     * @return
     */
    StatefulPacketRepository getRepository();

    /**
     * @return
     */
    SessionManager<?> getSessionManager();

}
