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
    private int index;

    /**
     * The stack size in the container
     */
    private int amount;

    /**
     * The item
     */
    private Item item;

    /**
     * the item in the container entry, prioritise items with id of Item.NULL rather than setting as null
     */
    public ContainerEntry(int index, int amount, Item item) {
        this.index = index;
        this.amount = amount;
        this.item = item;
    }

    /**
     * Creates a default entry
     *
     * @param index
     */
    public ContainerEntry(int index) {
        this (index, 0, Item.nullItem());
    }

    /**
     * Indicates the index is empty
     *
     * @return
     */
    public boolean isEmpty() {
        return item == null || amount == 0 || item == Item.NULL;
    }

    /**
     * The item in the index
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
            item = Item.NULL;
        this.item = item;
        return this;
    }

    /**
     * Gets the index
     *
     * @return
     */
    public int getIndex() {
        return this.index;
    }

    /**
     * Sets the index index
     *
     * @param index
     */
    public ContainerEntry setIndex(int index) {
        this.index = index;
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
        if (this.amount <= 0) {
            this.setItem(null);
            this.amount = 0;
        }
        return this;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof ContainerEntry) {
            ContainerEntry o = (ContainerEntry) other;
            return o.getItem().equals(this.item) && o.getAmount() == this.amount && o.getIndex() == this.index;
        }
        else if (other instanceof Item) {
            return this.item.equals(other);
        }
        return false;
    }

}
