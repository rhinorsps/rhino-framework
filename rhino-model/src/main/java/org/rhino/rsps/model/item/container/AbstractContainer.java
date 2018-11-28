package org.rhino.rsps.model.item.container;

import org.rhino.rsps.model.item.Item;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * TODO: Problems: The set is initialized empty which means when the client has them in memory, they won't be synced correctly
 */
public abstract class AbstractContainer implements Container {

    /**
     * Indicates when the items should stack
     */
    private final StackingPolicy stackingPolicy;

    /**
     * The set of entries
     */
    private final ContainerEntry[] entries;

    /**
     * The capacity of the container
     */
    private final int capacity;

    public AbstractContainer(int capacity, StackingPolicy stackingPolicy) {
        this.stackingPolicy = stackingPolicy;
        this.capacity = capacity;
        this.entries = initialize(new ContainerEntry[capacity]);
    }

    @Override
    public boolean add(Item item, int amount) {
        if (this.stacks(item) && this.contains(item)) {
            return this.find(item).increaseAmount(amount) != null;
        }
        if (!this.isFull()) {
            if (this.stacks(item)) {
                return allocate().setItem(item).setAmount(amount) != null;
            } else if (amount == 1) {
                push(allocate().setItem(item).setAmount(amount));
                return true;
            } else if (amount <= this.available()) {
                while (amount-- > 0)
                    this.add(item, 1);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Item item, int amount) {
        if (this.contains(item)) {
            if (this.stacks(item) || amount == 1) {
                return this.find(item).decreaseAmount(amount) != null;
            }
            else if (this.count(item) >= amount) {
                while (amount-- > 0)
                    this.remove(item, 1);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean set(Item item, int amount, int slot) {
        if (!this.entries[slot].isEmpty())
            return false;
        this.entries[slot].setItem(item).setAmount(amount);
        return true;
    }

    @Override
    public ContainerEntry get(int slot) {
        if (this.entries[slot] == null) {
            this.entries[slot] = new ContainerEntry(slot);
        }
        return this.entries[slot];
    }

    @Override
    public void push(ContainerEntry entry) {
        this.entries[entry.getIndex()] = entry;
    }

    @Override
    public void clear() {
        this.get().forEach(entry -> entry.setItem(null));
    }

    @Override
    public int capacity() {
        return this.capacity;
    }

    @Override
    public Stream<ContainerEntry> get() {
        return Arrays.stream(this.entries);
    }

    /**
     * Helper method to see if the item in question should stack
     *
     * @param item
     * @return
     */
    private boolean stacks(Item item) {
        return this.stackingPolicy == StackingPolicy.ALWAYS || (stackingPolicy == StackingPolicy.INHERITED && item.isStackable());
    }

    /**
     * Initializes the entries
     *
     * @param entries
     * @return
     */
    private ContainerEntry[] initialize(ContainerEntry[] entries) {
        for (int i = 0; i < entries.length; i++)
            entries[i] = new ContainerEntry(i);
        return entries;
    }

    /**
     * Indicates when the items should stack
     */
    public enum StackingPolicy {
        /**
         * Items should never stack, regardless of how it's defined in their description
         */
        NEVER,

        /**
         * Stackability inherited from the item's definition
         */
        INHERITED,

        /**
         * Items should always stack, regardless of their definition
         */
        ALWAYS;
    }

}
