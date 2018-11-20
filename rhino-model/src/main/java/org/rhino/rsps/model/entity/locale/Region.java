package org.rhino.rsps.model.entity.locale;

public class Region extends AbstractLocation {

    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;

    /**
     *
     * @param location
     * @return
     */
    public static Region of(Location location) {
        if (location instanceof Region) {
            return (Region) location.copy();
        }
        return new Region(location.x() / WIDTH, location.y() / HEIGHT);
    }

    /**
     * Regions do not have a z-value
     *
     * @param x
     * @param y
     */
    public Region(int x, int y) {
        super(x, y);
    }

    @Override
    public Location copy() {
        return new Region(this.x, this.y);
    }

    public Location deflate() {
        return this;
    }

    @Override
    public Location inflate() {
        return new AbsoluteLocation(x() * WIDTH, y() * HEIGHT, z());
    }

}
