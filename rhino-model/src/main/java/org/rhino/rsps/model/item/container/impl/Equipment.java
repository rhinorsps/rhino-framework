package org.rhino.rsps.model.item.container.impl;

import org.rhino.rsps.model.item.container.AbstractContainer;
import org.rhino.rsps.model.item.container.ObservableContainer;

public class Equipment extends ObservableContainer {

    public Equipment(int capacity) {
        super(capacity, StackingPolicy.NEVER);
    }

}
