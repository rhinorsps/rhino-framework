package org.rhino.rsps.model.entity.actor.transformation.impl;

import org.rhino.rsps.model.entity.Entity;
import org.rhino.rsps.model.entity.actor.transformation.Transformation;

public class FaceEntity implements Transformation {

    private final Entity entity;

    public FaceEntity(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }
    
}
