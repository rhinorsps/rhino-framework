package org.rhino.rsps.model.entity.locale;

public class RelativeLocation extends AbstractLocation {

    /**
     * The region
     */
    private final Region region;

    public RelativeLocation(Region region, int x, int y) {
        this(region, x, y, DEFAULT_Z);
    }

    public RelativeLocation(Region region, int x, int y, int z) {
        super(x, y, z);
        this.region = region;
    }

    @Override
    public Location inflate() {
        return region.copy().inflate().adjust(x(), y());
    }

    @Override
    public Location copy() {
        return new RelativeLocation(region, x(), y(), z());
    }

}
