package org.rhino.rsps.model.item.container;

import java.util.Set;

public class ContainerEvent<ITEM extends ContainerItem> {

    /**
     * The modified items
     */
    private final Set<ITEM> modifiedItems;

    /**
     * The container being modified
     */
    private final Container<ITEM> container;

    public ContainerEvent(Set<ITEM> modifiedItems, Container<ITEM> container) {
        this.modifiedItems = modifiedItems;
        this.container = container;
    }

    public Set<ITEM> getModifiedItems() {
        return modifiedItems;
    }

    public Container<ITEM> getContainer() {
        return container;
    }
}
