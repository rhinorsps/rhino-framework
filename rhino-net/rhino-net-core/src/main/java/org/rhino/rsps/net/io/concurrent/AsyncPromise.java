package org.rhino.rsps.net.io.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;

public class AsyncPromise<T> extends AbstractPromise<T> {

    private final ExecutorService executorService;

    public AsyncPromise(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public void fail(Throwable t) {
        executorService.submit(() -> super.errorConsumer.accept(t));
    }

    @Override
    public void fulfill(T result) throws Exception {
        executorService.submit(() -> super.consumer.accept(result));
    }

}
