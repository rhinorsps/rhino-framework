package org.rhino.rsps.model.item.container.impl;

import org.rhino.rsps.model.item.Item;
import org.rhino.rsps.model.item.container.ContainerEntry;
import org.rhino.rsps.model.item.container.ContainerEvent;
import org.rhino.rsps.model.item.container.EditableContainer;
import org.rhino.rsps.model.item.container.ObservableContainer;

import java.util.Set;

public class Bank extends EditableContainer {

    public static final int BANK_CAPACITY = 384;

    public Bank() {
        super(BANK_CAPACITY, StackingPolicy.ALWAYS);
    }

    public Bank(int capacity) {
        super(capacity, StackingPolicy.ALWAYS);
    }

}
