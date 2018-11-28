package org.rhino.rsps.model.item.container;

import org.rhino.rsps.model.item.Item;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public abstract class ObservableContainer extends AbstractContainer {

    /**
     * The collection of listeners
     */
    private final Queue<ContainerListener> listenerQueue = new LinkedList<>();

    /**
     *
     * @param capacity
     * @param stackingPolicy
     */
    public ObservableContainer(int capacity, StackingPolicy stackingPolicy) {
        super(capacity, stackingPolicy);
    }

    /**
     * @param event
     */
    public void fireUpdate(ContainerEvent event) {
        this.listenerQueue.forEach(listener -> listener.containerUpdated(event));
    }

    /**
     * Adds a new listener
     *
     * @param listener
     */
    public void addListener(ContainerListener listener) {
        this.listenerQueue.add(listener);
    }

    /**
     * Removes the listener
     *
     * @param listener
     */
    public void removeListener(ContainerListener listener) {
        this.listenerQueue.remove(listener);
    }

    @Override
    public boolean add(Item item, int amount) {
        try {
            return super.add(item, amount);
        } finally {
            this.fireContainerChangedEvent();
        }
    }

    @Override
    public boolean remove(Item item, int amount) {
        try {
            return super.remove(item, amount);
        } finally {
            this.fireContainerChangedEvent();
        }
    }

    @Override
    public boolean set(Item item, int amount, int slot) {
        try {
            return super.set(item, amount, slot);
        } finally {
            this.fireContainerChangedEvent();
        }
    }

    @Override
    public void clear() {
        try {
            super.clear();
        } finally {
            this.fireContainerChangedEvent();
        }
    }

    /**
     * Fires a container changed event
     *
     * TODO: figure how to get the modified items correctly listed without comparing (performance)
     */
    private void fireContainerChangedEvent() {
        this.listenerQueue.forEach(listener -> listener.containerUpdated(new ContainerEvent(super.get().collect(Collectors.toSet()), this)));
    }

}
