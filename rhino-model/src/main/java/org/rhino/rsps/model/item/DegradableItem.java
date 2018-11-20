package org.rhino.rsps.model.item;

public interface DegradableItem extends Item {

    /**
     *
     */
    int DEFAULT_DRAIN_RATE = 1;

    /**
     * Gets the remaining amount of charges
     * @return
     */
    int getRemainingCharges();

    /**
     * The maximum amount of charges
     * @return
     */
    int getMaximumCharges();

    /**
     *
     * @param amount
     */
    void drain(int amount);

    /**
     * Helper method to drain by the default drain rate
     */
    default void drain() {
        this.drain(DegradableItem.DEFAULT_DRAIN_RATE);
    }

}
