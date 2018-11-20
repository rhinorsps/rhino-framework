package org.rhino.rsps.model.entity.object;

import org.rhino.rsps.model.entity.Entity;

/**
 * Called GameObject instead of Object as to not conflict with java.lang.Object
 */
public interface GameObject extends Entity {

    /**
     * The object's orientation
     *
     * @return
     */
    Orientation getOrientation();

    /**
     * The object's type (e.g. SOLID, SCENERY, ...)
     * @return
     */
    Type getType();

    /**
     *
     * @return
     */
    GameObjectDefinition getDefinition();

}
