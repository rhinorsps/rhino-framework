package org.rhino.rsps.model.item;

public class SimpleItem implements Item {

    private final int id;

    public SimpleItem(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Item)
            return ((Item) other).getId() == id;
        return false;
    }

    @Override
    public int getId() {
        return id;
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

    @Override
    public int id() {
        return 0;
    }

}
