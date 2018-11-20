package org.rhino.rsps.model.entity.actor.transformation.impl;

import org.rhino.rsps.model.entity.actor.transformation.Transformation;
import org.rhino.rsps.model.entity.locale.Location;

public class Motion implements Transformation {

    private final Location source;
    private final Location target;

    public Motion(Location source, Location target) {
        this.source = source;
        this.target = target;
    }

    public Location getSource() {
        return source;
    }

    public Location getTarget() {
        return target;
    }

}
