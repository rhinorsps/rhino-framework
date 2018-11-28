package org.rhino.rsps.model.item.container;

import org.rhino.rsps.model.item.Item;

import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.Stream;

public interface Container extends Supplier<Stream<ContainerEntry>>, Iterable<ContainerEntry> {

    /**
     * Adds an item to the container
     *
     * @param item
     * @param amount
     * @return
     */
    boolean add(Item item, int amount);

    /**
     * Removes an item from the container
     *
     * @param item
     * @param amount
     * @return
     */
    boolean remove(Item item, int amount);

    /**
     * Sets the item at the given getIndex
     *
     * @param item
     * @param amount
     * @param slot
     * @return
     */
    boolean set(Item item, int amount, int slot);

    /**
     * Gets the container item at the given getIndex
     *
     * @param slot
     * @return
     */
    ContainerEntry get(int slot);

    /**
     * Sets the item at the given getIndex
     *
     * @param entry
     * @return
     */
    void push(ContainerEntry entry);

    /**
     * Clears the container
     */
    void clear();

    /**
     * Gets the capacity of the container
     *
     * @return
     */
    int capacity();

    /**
     * Gets the first available item
     *
     * @return
     */
    default ContainerEntry allocate() {
        return this.find(Item.nullItem());
    }

    /**
     * @return
     */
    default int available() {
        return (int) this.get().filter(entry -> entry.isEmpty()).count();
    }

    /**
     * Gets the amount of items with the given id
     *
     * @param item
     * @return
     */
    default int count(Item item) {
        return this.get().filter(entry -> entry.getItem().equals(item)).mapToInt(entry -> entry.getAmount()).sum();
    }

    /**
     * Checks to see if the item is in the container
     *
     * @param item
     * @param amount
     * @return
     */
    default boolean contains(Item item, int amount) {
        return this.count(item) >= amount;
    }

    /**
     * Helper method for contains(id, 1)
     *
     * @param item
     * @return
     */
    default boolean contains(Item item) {
        return this.contains(item, 1);
    }

    /**
     * Finds the first occurrence of the given item id
     *
     * @param item
     * @return
     */
    default ContainerEntry find(Item item) {
        return this.get().filter(slot -> slot.getItem().equals(item)).findFirst().orElse(null);
    }

    /**
     * Checks to see if the container is empty
     *
     * @return
     */
    default boolean isEmpty() {
        return available() == this.capacity();
    }

    /**
     * Checks to see if the container is full
     *
     * @return
     */
    default boolean isFull() {
        return this.allocate() == null;
    }

    @Override
    default Iterator<ContainerEntry> iterator() {
        return this.get().iterator();
    }

}
