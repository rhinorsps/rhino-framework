package org.rhino.rsps.model.entity.object;

import org.rhino.rsps.model.entity.Entity;

/**
 * Called RSObject instead of Object as to not conflict with java.lang.Object
 */
public interface RSObject extends Entity {

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
    RSObjectDefinition getDefinition();

}
