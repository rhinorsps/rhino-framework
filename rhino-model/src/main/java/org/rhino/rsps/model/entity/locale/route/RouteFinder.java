package org.rhino.rsps.model.entity.locale.route;

import org.rhino.rsps.model.entity.locale.Location;
import org.rhino.rsps.model.realm.Region;

public interface RouteFinder {

    /**
     * Attempts to find the closest path from the origin to the target
     *
     * @param origin
     * @param target
     * @return
     * @throws Exception
     */
    Route findRoute(Location origin, Location target, Region region) throws Exception;

}
