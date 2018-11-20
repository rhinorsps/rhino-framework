package org.rhino.rsps.model.entity.actor.transformation.impl;

import org.rhino.rsps.model.entity.actor.transformation.Transformation;

public class Graphic implements Transformation {

    private final int id;
    private final int height;
    private final int delay;

    public Graphic(int id, int height, int delay) {
        this.id = id;
        this.height = height;
        this.delay = delay;
    }

    public int getId() {
        return id;
    }

    public int getHeight() {
        return height;
    }

    public int getDelay() {
        return delay;
    }
}
