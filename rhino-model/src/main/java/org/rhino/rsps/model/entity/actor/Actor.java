package org.rhino.rsps.model.entity.actor;

import org.rhino.rsps.model.entity.Entity;
import org.rhino.rsps.model.entity.actor.transformation.Transformations;
import org.rhino.rsps.model.entity.locale.Route;
import org.rhino.rsps.model.entity.locale.RouteFinder;

public interface Actor extends Entity {

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
