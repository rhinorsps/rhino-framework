package org.rhino.rsps.model.item;

class NullItem implements Item {

    /**
     *
     */
    private static final int NULL = -1;

    @Override
    public int id() {
        return NULL;
    }

    @Override
    public int getId() {
        return NULL;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public boolean isTradable() {
        return false;
    }

    @Override
    public boolean isPremium() {
        return false;
    }

    @Override
    public boolean isStackable() {
        return false;
    }

}
