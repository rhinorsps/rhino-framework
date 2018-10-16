package org.rhino.rsps.net.io.concurrent;

import java.util.function.Consumer;

abstract class AbstractPromise<T> implements Promise<T> {

    /**
     * The consumer
     */
    protected Consumer<T> consumer;

    /**
     * The consumer that consumer errors lol
     */
    protected Consumer<Throwable> errorConsumer;

    @Override
    public Promise<T> success(Consumer<T> consumer) {
        this.consumer = consumer;
        return this;
    }

    @Override
    public Promise<T> error(Consumer<Throwable> consumer) {
        this.errorConsumer = errorConsumer;
        return this;
    }

}
