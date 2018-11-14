package org.rhino.rsps.net.netty;


import org.junit.Test;
import org.rhino.rsps.net.Server;
import org.rhino.rsps.net.ServerContext;
import org.rhino.rsps.net.packet.definition.PacketDefinition;
import org.rhino.rsps.net.packet.definition.PacketDefinitionRepository;
import org.rhino.rsps.net.session.Session;
import org.rhino.rsps.net.session.SessionContext;
import org.rhino.rsps.net.session.SessionManager;

import java.net.InetSocketAddress;
import java.net.Socket;

public class NettyServerTest {

    private static final int port = 43599;
    private static final String host = "localhost";

    /**
     * FIXME: exceptions will never cause this to fail, exceptions are caught and handled internally ...
     */
    @Test
    public void testNettyController() throws Exception {
        Server nettyServer = new NettyServer(new DummyServerContext());
        nettyServer.serve();

        Socket socket = new Socket();
        socket.connect(nettyServer.getServerContext().getHostAddress());
        socket.close();

        nettyServer.shutdown();
    }

    private class DummyServerContext implements ServerContext {

        @Override
        public InetSocketAddress getHostAddress() {
            return new InetSocketAddress(host, port);
        }

        @Override
        public PacketDefinitionRepository getRepository() {
            return new DummyRepository();
        }

        @Override
        public SessionManager getSessionManager() {
            return new DummySessionManager();
        }

    }

    private class DummySessionManager implements SessionManager {
        @Override
        public Session register(Session session) {
            return null;
        }

        @Override
        public Session remove(Session session) {
            return null;
        }
    }

    private class DummyRepository implements PacketDefinitionRepository {

        @Override
        public PacketDefinition get(int opcode, SubRepository subRepository) {
            return null;
        }
    }

}
