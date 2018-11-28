package org.rhino.rsps.model.item.container;

import org.rhino.rsps.model.item.Item;

import java.util.Set;

/**
 * A container that can modify the order of its components
 */
public abstract class EditableContainer extends ObservableContainer {

    public EditableContainer(int capacity, StackingPolicy policy) {
        super(capacity, policy);
    }

    /**
     * Inserts an item into the given source entry and shifts every subsequent item index by i
     *
     * @param source
     * @param target
     */
    public void insert(ContainerEntry source, ContainerEntry target) {
        // TODO
    }

    /**
     * Helper method for insert(get(source), get(target))
     *
     * @param sourceEntry
     * @param targetEntry
     */
    public void insert(int sourceEntry, int targetEntry) {
        this.insert(super.get(sourceEntry), super.get(targetEntry));
    }

    /**
     * Swaps the index of 2 entries
     *
     * @param source
     * @param target
     */
    public void swap(ContainerEntry source, ContainerEntry target) {
        Item sourceItem = source.getItem();
        int sourceAmount = source.getAmount();

        source.setItem(target.getItem()).setAmount(target.getAmount());
        target.setItem(sourceItem).setAmount(sourceAmount);

        super.fireUpdate(new ContainerEvent(Set.of(source, target), this));
    }

    /**
     * Helper method for swap(get(source), get(target))
     *
     * @param sourceEntry
     * @param targetEntry
     */
    public void swap(int sourceEntry, int targetEntry) {
        this.swap(super.get(sourceEntry), super.get(targetEntry));
    }

}
