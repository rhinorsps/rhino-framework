package org.rhino.rsps.model.entity.actor.transformation.impl;

import org.rhino.rsps.model.entity.actor.transformation.Transformation;

public class Animation implements Transformation {

    private final int id;
    private final int delay;

    public Animation(int id, int delay) {
        this.id = id;
        this.delay = delay;
    }

    public int getId() {
        return id;
    }

    public int getDelay() {
        return delay;
    }

}
