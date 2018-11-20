package org.rhino.rsps.model.entity.locale;

public abstract class AbstractLocation implements Location {

    protected int x;
    protected int y;
    protected int z;

    public AbstractLocation(int x, int y) {
        this(x, y, DEFAULT_Z);
    }

    public AbstractLocation(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Location offset() {
        return Region.of(this);
    }

    @Override
    public Location offset(Location other) {
        return this.copy().adjust(-other.x(), -other.y(), -other.z());
    }

    @Override
    public Location adjust(int x, int y, int z) {
        return x(x() + x).y(y() + y).z(z() + z);
    }

    @Override
    public Location set(int x, int y, int z) {
        return x(x).y(y).z(z);
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
