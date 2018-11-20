package org.rhino.rsps.model.entity.actor.transformation.impl;

import org.rhino.rsps.model.entity.actor.transformation.Transformation;

public class Speech implements Transformation {

    private final String text;

    public Speech(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
