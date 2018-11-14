package org.rhino.rsps.net;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public abstract class AsyncServer extends AbstractServer {

    /**
     * The executor service running the async service
     */
    private final ExecutorService service;

    /**
     *
     */
    private Future<?> future;

    public AsyncServer(ServerContext context) {
        this(Executors.newSingleThreadExecutor(), context);
    }

    public AsyncServer(ExecutorService service, ServerContext context) {
        super(context);
        this.service = service;
    }

    @Override
    public void serve() throws Exception {
        this.future = service.submit(() -> serveAsync(service));
    }

    @Override
    public void shutdown() throws Exception {
        shutdownAsync(service);
        future.cancel(true);
    }

    /**
     * @throws Exception
     */
    public abstract <T> T serveAsync(ExecutorService service) throws Exception;

    /**
     * @param service
     * @throws Exception
     */
    public abstract void shutdownAsync(ExecutorService service) throws Exception;

}
