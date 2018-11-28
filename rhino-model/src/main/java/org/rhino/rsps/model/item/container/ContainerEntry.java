package org.rhino.rsps.model.item.container;

import org.rhino.rsps.model.item.Item;

public class ContainerEntry {

    /**
     * The max stack size
     */
    public static final int MAX_STACK_SIZE = Integer.MAX_VALUE;

    /**
     * The index in the container
     */
    private int slot;

    /**
     * The stack size in the container
     */
    private int amount;

    /**
     * the item in the container entry, prioritise items with id of Item.NULL rather than setting as null
     */

    public ContainerEntry(int slot, int amount, Item item) {
        this.slot = slot;
        this.amount = amount;
        this.item = item;
    }
    private Item item;

    /**
     * Creates a default entry
     *
     * @param slot
     */
    public ContainerEntry(int slot) {
        this (slot, 0, Item.nullItem());
    }

    /**
     * Indicates the slot is empty
     *
     * @return
     */
    public boolean isEmpty() {
        return item == null || amount == 0 || item.getId() == Item.NULL;
    }

    /**
     * The item in the slot
     *
     * @return
     */
    public Item getItem() {
        return this.item;
    }

    /**
     * Sets the item
     *
     * @param item
     */
    public ContainerEntry setItem(Item item) {
        if (item == null)
            item = Item.get(Item.NULL);
        this.item = item;
        return this;
    }

    /**
     * Gets the slot
     *
     * @return
     */
    public int getIndex() {
        return this.slot;
    }

    /**
     * Gets the slot in the container
     *
     * @return
     */
    public int getSlot() {
        return slot;
    }

    /**
     * Sets the slot index
     *
     * @param slot
     */
    public ContainerEntry setSlot(int slot) {
        this.slot = slot;
        return this;
    }

    /**
     * Gets the amount
     * @return
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the item
     *
     * @param amount
     * @return
     */
    public ContainerEntry setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Increases the amount
     */
    public ContainerEntry increaseAmount(int amount) {
        this.amount += amount;
        if (this.amount < 0) {
            this.amount = MAX_STACK_SIZE;
        }
        return this;
    }

    /**
     * Increases the amount
     */
    public ContainerEntry decreaseAmount(int amount) {
        this.amount -= amount;
        if (this.amount < 0) {
            this.amount = 0;
        }
        return this;
    }

}
