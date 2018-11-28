package org.rhino.rsps.model.entity.actor.player;

import org.rhino.rsps.model.entity.actor.Actor;
import org.rhino.rsps.model.entity.locale.route.RouteFinder;
import org.rhino.rsps.model.item.container.impl.Bank;
import org.rhino.rsps.model.item.container.impl.Equipment;
import org.rhino.rsps.model.item.container.impl.Inventory;

public interface Player extends Actor {

    /**
     * The player's username (can be different from login-name)
     *
     * @return
     */
    Credentials getCredentials();

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

    /**
     *
     * @return
     */
    RouteFinder getRouteFinder();

}
