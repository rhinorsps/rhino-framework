package org.rhino.rsps.model.item.container;

import org.rhino.rsps.model.item.Item;

import java.util.Set;

public class AbstractContainer<ITEM extends ContainerItem> implements Container<ITEM> {

    @Override
    public boolean add(Item item) {
        return false;
    }

    @Override
    public boolean set(Item item, int slot) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Set<ITEM> get() {
        return null;
    }

    @Override
    public ITEM get(int slot) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

}
