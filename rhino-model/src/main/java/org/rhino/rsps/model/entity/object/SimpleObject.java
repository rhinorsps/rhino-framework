package org.rhino.rsps.model.entity.object;

import org.rhino.rsps.model.entity.AbstractEntity;
import org.rhino.rsps.model.entity.locale.Location;
import org.rhino.rsps.model.realm.Realm;

public class SimpleObject extends AbstractEntity implements GameObject {

    /**
     * The object's type
     */
    private final Type type;

    /**
     * The object's orientation
     */
    private final Orientation orientation;

    /**
     * The object's definition
     */
    private final GameObjectDefinition definition;

    public SimpleObject(int id, Location location, GameObjectDefinition definition, Type type, Orientation orientation) {
        super(id, location);

        this.type = type;
        this.orientation = orientation;
        this.definition = definition;
    }

    @Override
    public Orientation getOrientation() {
        return this.getOrientation();
    }

    @Override
    public Type getType() {
        return this.getType();
    }

    @Override
    public GameObjectDefinition getDefinition() {
        return this.getDefinition();
    }
}
