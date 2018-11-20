package org.rhino.rsps.model.item.container;

import org.rhino.rsps.model.item.Item;

import java.util.Set;

public interface Container<ITEM extends ContainerItem> {

    /**
     * Adds an item to the container
     *
     * @param item
     */
    boolean add(Item item);

    /**
     * Sets the item at the given getIndex
     *
     * @param item
     * @param slot
     */
    boolean set(Item item, int slot);

    /**
     * Clears the container
     */
    void clear();

    /**
     * Gets all the items in the container (null items are returned as id -1)
     * @return
     */
    Set<ITEM> get();

    /**
     * Gets the container item at the given getIndex
     *
     * @param slot
     * @return
     */
    ITEM get(int slot);

    /**
     * Gets the size of the container
     * @return
     */
    int size();

    /**
     * Gets the first available item
     *
     * @return
     */
    default ITEM allocate() {
        return this.find(ContainerItem.NULL);
    }

    /**
     * Swaps the position of 2 items
     *
     * @param source
     * @param target
     */
    default void swap(int source, int target) {
        ITEM sourceItem = this.get(source);
        ITEM targetItem = this.get(target);

        this.set(sourceItem, targetItem.getIndex());
        this.set(targetItem, sourceItem.getIndex());
    }

    /**
     *
     */
    default void insert(int source, int target) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    /**
     * Gets the amount of items with the given id
     *
     * @param id
     * @return
     */
    default int count(int id) {
        return this.get().stream().filter(item -> item.getDefinition().getId() == id).mapToInt(item -> item.getStackSize()).sum();
    }

    /**
     *
     * @return
     */
    default int free() {
        return this.count(ContainerItem.NULL);
    }

    /**
     * Checks to see if the item is in the container
     *
     * @param id
     * @param amount
     * @return
     */
    default boolean contains(int id, int amount) {
        return this.count(id) >= amount;
    }

    /**
     * Helper method
     *
     * @param id
     * @return
     */
    default boolean contains(int id) {
        return this.contains(id, 1);
    }

    /**
     * Finds the first occurence of the given item id
     * @param id
     * @return
     */
    default ITEM find(int id) {
        return this.get().stream().filter(item -> item.getDefinition().getId() == id).findFirst().get();
    }

    /**
     * Checks to see if the container is empty
     * @return
     */
    default boolean isEmpty() {
        return this.contains(ContainerItem.NULL, this.size());
    }

    /**
     * Checks to see if the container is full
     *
     * @return
     */
    default boolean isFull() {
        return this.allocate() == null;
    }

}
