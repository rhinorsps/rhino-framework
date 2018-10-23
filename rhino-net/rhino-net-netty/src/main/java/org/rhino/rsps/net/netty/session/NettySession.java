package org.rhino.rsps.net.netty.session;

import io.netty.channel.Channel;
import org.rhino.rsps.net.session.AbstractSession;
import org.rhino.rsps.net.session.Session;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class NettySession extends AbstractSession {

    /**
     * The Netty {@link Channel}
     */
    private final Channel channel;

    /**
     * creates a new session with the netty channel and a default context
     * @param channel
     */
    public NettySession(Channel channel) {
        this.channel = channel;
    }

    @Override
    public CompletableFuture<Session> destroy() throws IOException {
        CompletableFuture<Session> future = new CompletableFuture<>();
        channel.close().addListener(f -> future.complete(NettySession.this));
        return future;
    }

}
