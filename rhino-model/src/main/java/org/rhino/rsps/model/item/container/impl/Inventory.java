package org.rhino.rsps.model.item.container.impl;

import org.rhino.rsps.model.item.container.EditableContainer;

public class Inventory extends EditableContainer {

    public static final int INVENTORY_CAPACITY = 28;

    public Inventory(int capacity) {
        super(capacity, StackingPolicy.INHERITED);
    }

    public Inventory() {
        super(INVENTORY_CAPACITY, StackingPolicy.INHERITED);
    }

}
