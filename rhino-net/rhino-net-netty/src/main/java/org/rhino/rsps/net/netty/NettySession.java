package org.rhino.rsps.net.netty;

import io.netty.channel.Channel;
import io.netty.util.concurrent.GenericFutureListener;
import org.rhino.rsps.net.session.Session;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class NettySession implements Session {

    /**
     * The Netty {@link Channel}
     */
    private final Channel channel;

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
