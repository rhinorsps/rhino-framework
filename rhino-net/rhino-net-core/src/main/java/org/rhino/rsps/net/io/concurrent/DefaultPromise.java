package org.rhino.rsps.net.io.concurrent;

public class DefaultPromise<T> extends AbstractPromise<T> {

    @Override
    public void fail(Throwable t) {
        super.errorConsumer.accept(t);
    }

    @Override
    public void fulfill(T result) throws Exception {
        super.consumer.accept(result);
    }

}
