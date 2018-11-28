package org.rhino.rsps.model.entity.locale;

import org.rhino.rsps.model.entity.locale.route.Direction;

public interface Location {

    /**
     * @return
     */
    int x();

    /**
     * @return
     */
    int y();

    /**
     * @return the Z coordinate value
     */
    int z();

    /**
     * Sets the X coordinate value
     *
     * @param x
     * @return this location instance for chaining
     */
    Location x(int x);

    /**
     * @param y
     * @return
     */
    Location y(int y);

    /**
     * @param z
     * @return
     */
    Location z(int z);

    /**
     * Copies the location
     *
     * @return
     */
    Location copy();

    /**
     * @param x
     * @param y
     * @param z
     * @return
     */
    default Location set(int x, int y, int z) {
        return this.x(x).y(y).z(z);
    }

    /**
     * @param x
     * @param y
     * @return
     */
    default Location set(int x, int y) {
        return this.set(x, y, z());
    }

    /**
     * Adjusts the location
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    default Location adjust(int x, int y, int z) {
        return this.set(x() + x, y() + y, z() +z );
    }

    /**
     * @param x
     * @param y
     * @return
     */
    default Location adjust(int x, int y) {
        return this.adjust(x, y, z());
    }

    /**
     * Adjusts the location based on a direction
     *
     * @param direction
     * @return
     */
    default Location adjust(Direction direction) {
        return this.adjust(direction.getX(), direction.getY());
    }

    /**
     * @param o
     * @return
     */
    default int distance(Location o) {
        return (int) Math.ceil(Math.sqrt(Math.pow(x() - o.x(), 2) + Math.pow(y() - o.y(), 2)));
    }

}
