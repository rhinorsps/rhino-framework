package org.rhino.rsps.model.entity.locale;

public class AbsoluteLocation extends AbstractLocation {

    public AbsoluteLocation(int x, int y) {
        super(x, y);
    }

    public AbsoluteLocation(int x, int y, int z) {
        super(x, y, z);
    }

    @Override
    public Location copy() {
        return new AbsoluteLocation(x(), y(), z());
    }

    @Override
    public Location inflate() {
        return this;
    }

}
