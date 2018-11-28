package org.rhino.rsps.model.item.container.impl;

import org.rhino.rsps.model.item.container.AbstractContainer;
import org.rhino.rsps.model.item.container.ObservableContainer;

public class Equipment extends ObservableContainer {

    public static final int CAPACITY = 24;

    public Equipment() {
        super(CAPACITY, StackingPolicy.NEVER);
    }

}
