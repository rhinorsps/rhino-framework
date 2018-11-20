package org.rhino.rsps.model.item.container;

import java.util.LinkedList;
import java.util.Queue;

public abstract class ObservableContainer<ITEM extends ContainerItem> extends AbstractContainer<ITEM> {

    /**
     * The collection of listeners
     */
    private final Queue<ContainerListener<ITEM>> listenerQueue = new LinkedList<>();

    /**
     *
     * @param event
     */
    public void fireUpdate(ContainerEvent<ITEM> event) {
        this.listenerQueue.forEach(listener -> listener.containerUpdated(event));
    }

    /**
     * Adds a new listener
     *
     * @param listener
     */
    public void addListener(ContainerListener<ITEM> listener) {
        this.listenerQueue.add(listener);
    }

    /**
     * Removes the listener
     *
     * @param listener
     */
    public void removeListener(ContainerListener<ITEM> listener) {
        this.listenerQueue.remove(listener);
    }

}
