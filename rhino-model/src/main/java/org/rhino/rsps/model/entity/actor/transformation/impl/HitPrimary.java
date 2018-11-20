package org.rhino.rsps.model.entity.actor.transformation.impl;

import org.rhino.rsps.model.entity.actor.transformation.Transformation;

public class HitPrimary implements Transformation {

    private final int current;
    private final int max;
    private final int amount;
    private final int sprite;

    public HitPrimary(int current, int max, int amount, int sprite) {
        this.current = current;
        this.max = max;
        this.amount = amount;
        this.sprite = sprite;
    }

    public int getCurrent() {
        return current;
    }

    public int getMax() {
        return max;
    }

    public int getAmount() {
        return amount;
    }

    public int getSprite() {
        return sprite;
    }
}
