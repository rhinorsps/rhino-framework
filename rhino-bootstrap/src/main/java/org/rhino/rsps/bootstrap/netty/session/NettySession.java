package org.rhino.rsps.bootstrap.netty.session;

import io.netty.channel.socket.SocketChannel;
import org.rhino.rsps.core.session.AbstractSession;
import org.rhino.rsps.core.session.Session;
import org.rhino.rsps.core.session.SessionContext;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class NettySession extends AbstractSession<SocketChannel> {

    /**
     * The backing socket channel for i/o
     */
    private final SocketChannel socketChannel;

    public NettySession(SessionContext context, SocketChannel socketChannel) {
        super(context);
        this.socketChannel = socketChannel;
    }

    @Override
    public <T> CompletableFuture<T> write(T t) throws IOException {
        CompletableFuture<T> future = new CompletableFuture<>();
        this.socketChannel.write(t).addListener(f -> future.complete(t));
        return future;
    }

    @Override
    public CompletableFuture<Session<SocketChannel>> disconnect() throws IOException {
        this.getContext().setState(SessionContext.State.DISCONNECTED);
        return this.destroy();
    }

    @Override
    public CompletableFuture<Session<SocketChannel>> destroy() throws IOException {
        CompletableFuture<Session<SocketChannel>> future = new CompletableFuture<>();
        this.socketChannel.disconnect().addListener(f -> future.complete(NettySession.this));
        return future;
    }

    @Override
    public void flush() throws IOException {
        this.socketChannel.flush();
    }

}
