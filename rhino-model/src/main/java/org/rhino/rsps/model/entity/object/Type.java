package org.rhino.rsps.model.entity.object;

public enum Type {

    /**
     * Traversable objects that are ignored in low-mem settings
     */
    SCENERY(0),

    /**
     * Solid objects that have clipping flags
     */
    SOLID(10);

    private final int id;

    Type(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
