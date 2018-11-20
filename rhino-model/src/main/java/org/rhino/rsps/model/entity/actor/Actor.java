package org.rhino.rsps.model.entity.actor;

import org.rhino.rsps.model.entity.Entity;
import org.rhino.rsps.model.entity.actor.transformation.Transformations;
import org.rhino.rsps.model.entity.locale.Location;
import org.rhino.rsps.model.entity.locale.Region;
import org.rhino.rsps.model.entity.locale.Route;
import org.rhino.rsps.model.entity.locale.RouteFinder;

public interface Actor extends Entity {

    /**
     * Gets the actor's location
     * @return
     */
    Location getLocation();

    /**
     * Gets the actor's region
     *
     * @return
     */
    Region getCurrentRegion();

    /**
     *
     * @return
     */
    Route getRoute();

    /**
     *
     * @return
     */
    RouteFinder getRouteFinder();

    /**
     * Gets the actor's transformations
     *
     * @return
     */
    Transformations getTransformations();

}
