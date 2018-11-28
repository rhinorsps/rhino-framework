package org.rhino.rsps.model.item.container;

import java.util.Set;

public class ContainerEvent {

    /**
     * The modified items
     */
    private final Set<ContainerEntry> modifiedItems;

    /**
     * The container being modified
     */
    private final Container container;

    public ContainerEvent(Set<ContainerEntry> modifiedItems, Container container) {
        this.modifiedItems = modifiedItems;
        this.container = container;
    }

    public Set<ContainerEntry> getModifiedItems() {
        return modifiedItems;
    }

    public Container getContainer() {
        return container;
    }

}
