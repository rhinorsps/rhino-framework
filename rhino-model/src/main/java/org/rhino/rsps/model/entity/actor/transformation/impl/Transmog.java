package org.rhino.rsps.model.entity.actor.transformation.impl;

import org.rhino.rsps.model.entity.actor.transformation.Transformation;

public class Transmog implements Transformation  {

    /**
     *
     */
    private final int npcType;

    public Transmog(int npcType) {
        this.npcType = npcType;
    }

    public int getNpcType() {
        return npcType;
    }

}
