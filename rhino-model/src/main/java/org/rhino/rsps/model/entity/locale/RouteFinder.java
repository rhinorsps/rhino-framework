package org.rhino.rsps.model.entity.locale;

public interface RouteFinder {

    /**
     * Attempts to find the closest path from the origin to the target
     *
     * @param origin
     * @param target
     * @return
     * @throws Exception
     */
    Route findRoute(Location origin, Location target, Location region) throws Exception;

}
