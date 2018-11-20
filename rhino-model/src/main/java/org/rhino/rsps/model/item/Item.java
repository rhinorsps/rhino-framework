package org.rhino.rsps.model.item;

import org.rhino.rsps.model.Node;

public interface Item extends Node {

    /**
     * Gets the size of the stack
     *
     * @return
     */
    int getStackSize();

    /**
     * Gets the definition of the item
     * @return
     */
    ItemDefinition getDefinition();

}
