package org.rhino.rsps.net;

import org.rhino.rsps.net.packet.PacketRepository;
import org.rhino.rsps.net.session.SessionManager;

import java.net.InetSocketAddress;

public interface ServerContext {

    /**
     *
     * @return
     */
    InetSocketAddress getHostAddress();

    /**
     *
     * @return
     */
    PacketRepository getPacketRepository();

    /**
     *
     * @return
     */
    SessionManager getSessionManager();

}
