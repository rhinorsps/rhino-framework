package org.rhino.rsps.net.netty;

import io.netty.channel.Channel;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class NettyStatefulSession extends AbstractStatefulSession {

    /**
     * The Netty {@link Channel}
     */
    private final Channel channel;

    /**
     * creates a new session with the netty session and a default context
     * @param channel
     */
    public NettyStatefulSession(Channel channel) {
        this.channel = channel;
    }

    @Override
    public CompletableFuture<Session> destroy() throws IOException {
        CompletableFuture<Session> future = new CompletableFuture<>();
        channel.close().addListener(f -> future.complete(NettyStatefulSession.this));
        return future;
    }

}
