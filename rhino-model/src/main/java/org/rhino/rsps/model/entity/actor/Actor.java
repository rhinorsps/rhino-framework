package org.rhino.rsps.model.entity.actor;

import org.rhino.rsps.model.entity.Entity;
import org.rhino.rsps.model.entity.actor.action.ActionQueue;
import org.rhino.rsps.model.entity.actor.transformation.Transformations;
import org.rhino.rsps.model.entity.locale.Location;
import org.rhino.rsps.model.entity.locale.route.Route;
import org.rhino.rsps.model.entity.locale.route.RouteFinder;

public interface Actor extends Entity {

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

    /**
     * Gets the action queue
     *
     * @return
     */
    ActionQueue getActionQueue();

}
