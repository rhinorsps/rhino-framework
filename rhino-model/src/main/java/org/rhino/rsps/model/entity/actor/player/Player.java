package org.rhino.rsps.model.entity.actor.player;

import org.rhino.rsps.model.entity.actor.Actor;
import org.rhino.rsps.model.item.container.Container;
import org.rhino.rsps.model.item.container.bank.Bank;
import org.rhino.rsps.model.item.container.equipment.Equipment;
import org.rhino.rsps.model.item.container.inventory.Inventory;

public interface Player extends Actor {

    /**
     * The player's username (can be different from login-name)
     *
     * @return
     */
    String getDisplayName();

    /**
     * The player's bank
     *
     * @return
     */
    Bank getBank();

    /**
     * The player's inventory
     *
     * @return
     */
    Inventory getInventory();

    /**
     * The player's equipment
     *
     * @return
     */
    Equipment getEquipment();

}
