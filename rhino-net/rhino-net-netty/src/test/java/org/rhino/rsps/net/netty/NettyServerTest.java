package org.rhino.rsps.net.netty;


import org.junit.Test;
import org.rhino.rsps.core.session.SessionManager;
import org.rhino.rsps.net.AsyncServer;
import org.rhino.rsps.net.Server;
import org.rhino.rsps.net.ServerContext;
import org.rhino.rsps.net.packet.repository.StatefulPacketRepository;

import java.net.InetSocketAddress;
import java.net.Socket;

public class NettyServerTest {

    private static final int port = 43599;
    private static final String host = "localhost";

    /**
     * FIXME: exceptions will never cause this to fail, exceptions are caught and handled internally in netty ...
     */
    @Test
    public void testNettyController() throws Exception {
        ServerContext context = new DummyServerContext();

        try (Server nettyServer = new AsyncServer(new NettyServer(context))) {
            nettyServer.publish();

            Socket socket = new Socket();
            socket.connect(context.getHostAddress());
            socket.close();
        }
    }

    private class DummyServerContext implements ServerContext {

        @Override
        public InetSocketAddress getHostAddress() {
            return new InetSocketAddress(host, port);
        }

        @Override
        public StatefulPacketRepository getRepository() {
            return null;
        }

        @Override
        public SessionManager getSessionManager() {
            return null;
        }
    }

}
