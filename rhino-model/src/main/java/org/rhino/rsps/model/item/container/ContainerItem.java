package org.rhino.rsps.model.item.container;

import org.rhino.rsps.model.item.Item;

public interface ContainerItem extends Item {

    /**
     * The item id of an empty getIndex
     */
    int NULL = -1;

    /**
     * The getIndex in the container
     */
    int getIndex();

}
