package org.rhino.rsps.model.item.container;

import org.rhino.rsps.model.item.Item;
import org.rhino.rsps.model.item.ItemDefinition;

public class AbstractContainerItem implements ContainerItem {

    private final int index;
    private final int stackSize;
    private final Item delegate;

    public AbstractContainerItem(int index, int stackSize, Item delegate) {
        this.index = index;
        this.stackSize = stackSize;
        this.delegate = delegate;
    }

    @Override
    public int getIndex() {
        return this.index;
    }

    @Override
    public int getStackSize() {
        return this.stackSize;
    }

    @Override
    public ItemDefinition getDefinition() {
        return this.delegate.getDefinition();
    }

    @Override
    public int id() {
        return this.index; // FIXME: autgenerated id
    }

    @Override
    public void destroy() throws Exception {
        throw new UnsupportedOperationException("item cannot be destroyed"); // FIXME
    }

}
