package org.rhino.rsps.model.entity.locale;

public interface Location {

    /**
     * Gets the absolute coordinates of the location
     * @return
     */
    Location inflate();

    /**
     * Gets the region associated with the location
     * @return
     */
    Location deflate();

    /**
     * Gets the coordinates relative to the given region
     *
     * @param region
     * @return
     */
    Location deflate(Location region);

    /**
     * Copies the location
     * @return
     */
    Location copy();

    /**
     * Adjusts the location
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    Location adjust(int x, int y, int z);

    /**
     *
     * @param x
     * @param y
     * @return
     */
    default Location adjust(int x, int y) {
        return this.adjust(x, y, z());
    }

    /**
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    Location set(int x, int y, int z);

    /**
     *
     * @param x
     * @param y
     * @return
     */
    default Location set(int x, int y) {
        return this.set(x, y, z());
    }

    /**
     *
     * @return
     */
    int x();

    /**
     *
     * @return
     */
    int y();

    /**
     *
     * @return
     */
    int z();

    /**
     *
     * @param x
     * @return
     */
    int x(int x);

    /**
     *
     * @param y
     * @return
     */
    int y(int y);

    /**
     *
     * @param z
     * @return
     */
    int z(int z);

}
