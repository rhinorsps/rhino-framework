package org.rhino.rsps.model.entity;

import org.rhino.rsps.model.entity.locale.AbsoluteLocation;
import org.rhino.rsps.model.entity.locale.Location;
import org.rhino.rsps.model.realm.Realm;

public abstract class AbstractEntity implements Entity {

    /**
     *
     */
    private static final Location DEFAULT_LOCATION = new AbsoluteLocation(0,0,0);

    /**
     * The ID of the entity
     */
    private final int id;

    /**
     * The entity's location
     */
    private final Location location;

    public AbstractEntity(int id) {
        this(id, DEFAULT_LOCATION.copy());
    }

    public AbstractEntity(int id, Location location) {
        this.id = id;
        this.location = location;
    }

    @Override
    public int id() {
        return this.id;
    }

    @Override
    public Location getLocation() {
        return this.location;
    }

}
