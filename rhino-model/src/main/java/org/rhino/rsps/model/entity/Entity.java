package org.rhino.rsps.model.entity;

import org.rhino.rsps.model.Node;
import org.rhino.rsps.model.entity.locale.Location;

/**
 *
 */
public interface Entity extends Node {

    /**
     * Gets the entity's absolute location
     *
     * @return
     */
    Location getLocation();

}
