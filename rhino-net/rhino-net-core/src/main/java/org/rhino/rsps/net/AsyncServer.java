package org.rhino.rsps.net;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * FIXME: Proper shutdown handling
 *
 * @param <T>
 */
public abstract class AsyncServer<T> implements Server {

    /**
     * The executor for this service
     */
    private final ExecutorService executor;

    /**
     *
     */
    private Future<T> future;

    public AsyncServer() {
        this (Executors.newSingleThreadExecutor());
    }

    public AsyncServer(ExecutorService executor) {
        this.executor = executor;
    }

    public abstract T asyncPublish() throws Exception;

    public abstract void asyncClose() throws Exception;

    @Override
    public void publish() throws Exception {
        if (future != null) {
            throw new IllegalStateException("server already running");
        }
        this.future = this.executor.submit(this::asyncPublish);
    }

    @Override
    public void close() throws Exception {
        if (future == null) {
            throw new IllegalStateException("server already closed");
        }
        asyncClose();
        future.cancel(true);
    }

}
