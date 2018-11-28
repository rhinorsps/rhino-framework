package org.rhino.rsps.model.item;

import org.rhino.rsps.model.item.Item;

public class TestItem implements Item {

    private final int id;
    private final boolean stackable;

    public TestItem(int id, boolean stackable) {
        this.id = id;
        this.stackable = stackable;
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
        return stackable;
    }

    @Override
    public int id() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Item) {
            Item other = (Item) o;
            return this.id == other.getId();
        }
        return false;
    }

}
