package org.rhino.rsps.net.netty.session;

import io.netty.channel.socket.SocketChannel;
import org.rhino.rsps.net.Controller;
import org.rhino.rsps.net.io.concurrent.Promise;
import org.rhino.rsps.net.session.RS2Session;
import org.rhino.rsps.net.session.Session;

import java.io.IOException;

public class NettySession extends RS2Session {

    /**
     * The socket channel attched to this session
     */
    private final SocketChannel socketChannel;

    public NettySession(Controller controller, SocketChannel socketChannel) {
        super(controller);
        this.socketChannel = socketChannel;
    }

    @Override
    public Promise<Session> read(Object message) throws IOException {
        return null;
    }

    @Override
    public Promise<Session> write(Object object) throws IOException {
        return null;
    }

    @Override
    public Promise<Session> disconnect() {
        return null;
    }

}
