package org.rhino.rsps.model.item;

public interface ItemDefinition {

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

}
