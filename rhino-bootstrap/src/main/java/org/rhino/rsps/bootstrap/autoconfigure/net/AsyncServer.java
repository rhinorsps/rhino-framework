package org.rhino.rsps.bootstrap.autoconfigure.net;

import org.rhino.rsps.net.Server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * FIXME: Proper shutdown handling
 *
 * @param <T>
 */
public class AsyncServer<T> implements Server<Future<T>> {

    /**
     * The executor for this service
     */
    private final ExecutorService executor;

    /**
     *
     */
    private Future<T> future;

    /**
     *
     */
    private final Server<T> delegate;

    /**
     * Creates a server wth a single thread executor
     * @param delegate
     */
    public AsyncServer(Server delegate) {
        this (Executors.newSingleThreadExecutor(), delegate);
    }

    public AsyncServer(ExecutorService executor, Server delegate) {
        this.executor = executor;
        this.delegate = delegate;
    }

    @Override
    public Future<T> publish() throws Exception {
        if (future != null) {
            throw new IllegalStateException("server already running");
        }
        return this.future = this.executor.submit(delegate::publish);
    }

    @Override
    public void close() throws Exception {
        if (future == null) {
            throw new IllegalStateException("server already closed");
        }
        delegate.close();
        future.cancel(true);
    }

}

