package org.rhino.rsps.model.item.container.inventory;

import org.rhino.rsps.model.item.Item;
import org.rhino.rsps.model.item.container.AbstractContainerItem;

public class InventoryItem extends AbstractContainerItem {

    public InventoryItem(int index, int stackSize, Item delegate) {
        super(index, stackSize, delegate);
    }

}
