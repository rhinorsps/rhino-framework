package org.rhino.rsps.model.entity.locale;

import static com.google.common.base.Preconditions.checkArgument;

public class RelativeLocation implements Location {

    private final int x;
    private final int y;
    private final int z;
    private final Location other;

    public RelativeLocation(Location location, Location other) {
        this (other.x() - location.x(), other.y() - location.y(), other.z() - location.z(), other);
    }

    public RelativeLocation(int x, int y, int z, Location other) {
        checkArgument(z == other.z(), "relative location must have same Z");
        this.x = x;
        this.y = y;
        this.z = z;
        this.other = other;
    }

    @Override
    public Location copy() {
        return new AbsoluteLocation(x(), y(), z());
    }

    @Override
    public int x() {
        return other.x() + this.x;
    }

    @Override
    public int y() {
        return other.y() + this.y;
    }

    @Override
    public int z() {
        return this.z;
    }

    @Override
    public Location x(int x) {
        throw new IllegalStateException("relative location is immutable");
    }

    @Override
    public Location y(int y) {
        throw new IllegalStateException("relative location is immutable");
    }

    @Override
    public Location z(int z) {
        throw new IllegalStateException("relative location is immutable");
    }

}
