package org.rhino.rsps.model.item;

import org.rhino.rsps.model.Node;

public interface Item extends Node {

    /**
     * The null item
     */
    Item NULL = new NullItem();

    /**
     * Gets the id of the item
     *
     * @return
     */
    int getId();

    /**
     * The item's examine text
     *
     * @return
     */
    String getDescription();

    /**
     * Indicates the item is tradeable or not
     *
     * @return
     */
    boolean isTradable();

    /**
     * Indicates the item is only usable by premium members
     *
     * @return
     */
    boolean isPremium();

    /**
     * Indicates the item is able to stack in the inventory
     *
     * @return
     */
    boolean isStackable();

    /**
     * A null item, used as empty slot in a container
     * @return
     */
    static Item nullItem() {
        return NULL;
    }

}
