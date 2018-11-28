package org.rhino.rsps.model.entity.actor.player;

import org.rhino.rsps.model.entity.locale.AbsoluteLocation;
import org.rhino.rsps.model.entity.locale.Location;
import org.rhino.rsps.model.item.container.impl.Bank;
import org.rhino.rsps.model.item.container.impl.Equipment;
import org.rhino.rsps.model.item.container.impl.Inventory;

public abstract class AbstractPlayer implements Player {

    /**
     * The player's equipment
     */
    private final Equipment equipment = new Equipment();

    /**
     * The player's inventory
     */
    private final Inventory inventory = new Inventory();

    /**
     * The player's bank
     */
    private final Bank bank = new Bank();

    /**
     * The default location
     */
    private final Location location = AbsoluteLocation.DEFAULT.copy();

    /**
     * The player's credentials
     */
    private final Credentials credentials;

    public AbstractPlayer(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public Credentials getCredentials() {
        return this.credentials;
    }

    @Override
    public Bank getBank() {
        return this.bank;
    }

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }

    @Override
    public Equipment getEquipment() {
        return this.equipment;
    }

    @Override
    public Location getLocation() {
        return this.location;
    }

}
