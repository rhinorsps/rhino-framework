package org.rhino.rsps.net;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public abstract class AsyncController extends AbstractController {

    /**
     * The executor service running the async service
     */
    private final ExecutorService service;

    /**
     *
     */
    private Future<?> future;

    public AsyncController() {
        this(Executors.newSingleThreadExecutor());
    }

    public AsyncController(ExecutorService service) {
        this.service = service;
    }

    @Override
    public void serve(InetSocketAddress address) throws Exception {
        this.future = service.submit(() -> serveAsync(address, service));
    }

    @Override
    public void shutdown() throws Exception {
        shutdownAsync(service);
        future.cancel(true);
    }

    /**
     * @param address
     * @throws Exception
     */
    public abstract <T> T serveAsync(InetSocketAddress address, ExecutorService service) throws Exception;

    /**
     * @param service
     * @throws Exception
     */
    public abstract void shutdownAsync(ExecutorService service) throws Exception;

}
