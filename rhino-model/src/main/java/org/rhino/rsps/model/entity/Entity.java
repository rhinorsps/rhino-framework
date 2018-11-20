package org.rhino.rsps.model.entity;

import org.rhino.rsps.model.entity.locale.Location;
import org.rhino.rsps.model.Node;

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

    /**
     * Gets the location relative to the current map chunk's coordinates
     *
     * @return
     */
    Location getLocalLocation();

    /**
     * Gets the region the entity is located in
     *
     * @return
     */
    Location getRegion();

}
