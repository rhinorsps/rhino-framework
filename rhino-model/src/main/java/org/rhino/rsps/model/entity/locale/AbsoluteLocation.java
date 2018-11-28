package org.rhino.rsps.model.entity.locale;

public class AbsoluteLocation implements Location {

    /**
     * The default location
     */
    public static final Location DEFAULT = new AbsoluteLocation(0, 0 , 0);

    private int x;
    private int y;
    private int z;

    public AbsoluteLocation(Location other) {
        this (other.x(), other.y(), other.z());
    }

    public AbsoluteLocation(int x, int y) {
        this (x, y, 0);
    }

    public AbsoluteLocation(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Location copy() {
        return new AbsoluteLocation(this);
    }

    @Override
    public int x() {
        return this.x;
    }

    @Override
    public int y() {
        return this.y;
    }

    @Override
    public int z() {
        return this.z;
    }

    @Override
    public Location x(int x) {
        this.x = x;
        return this;
    }

    @Override
    public Location y(int y) {
        this.y = y;
        return this;
    }

    @Override
    public Location z(int z) {
        this.z = z;
        return this;
    }

}
