package org.rhino.rsps.model.item.container;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.rhino.rsps.model.item.Item;
import org.rhino.rsps.model.item.TestItem;
import org.rhino.rsps.model.item.container.impl.Inventory;

public class EditableContainerTest {

    private static final Item TEST_ITEM_NON_STACKABLE = new TestItem(4151, false);
    private static final Item TEST_ITEM_STACKABLE = new TestItem(995, true);

    @Test
    @Ignore
    public void testInsert() {
        EditableTestContainer inventory = new EditableTestContainer();

        Assert.assertTrue(inventory.add(TEST_ITEM_NON_STACKABLE, 1));
        Assert.assertTrue(inventory.add(TEST_ITEM_STACKABLE, 100));
        Assert.assertTrue(inventory.add(TEST_ITEM_NON_STACKABLE, 1));
        Assert.assertTrue(inventory.add(TEST_ITEM_STACKABLE, 100));

        inventory.insert(3, 0);

        Assert.assertEquals(inventory.get(0), TEST_ITEM_STACKABLE);
        Assert.assertEquals(inventory.get(1), TEST_ITEM_NON_STACKABLE);
        Assert.assertEquals(inventory.get(2), TEST_ITEM_STACKABLE);
        Assert.assertEquals(inventory.get(3), TEST_ITEM_NON_STACKABLE);
    }

    @Test
    public void testSwap() {
        EditableTestContainer inventory = new EditableTestContainer();

        Assert.assertTrue(inventory.add(TEST_ITEM_STACKABLE, 100));
        Assert.assertTrue(inventory.add(TEST_ITEM_NON_STACKABLE, 1));

        inventory.swap(0, 1);

        Assert.assertEquals(inventory.get(0), TEST_ITEM_NON_STACKABLE);
        Assert.assertEquals(inventory.get(1), TEST_ITEM_STACKABLE);
    }

    public static class EditableTestContainer extends EditableContainer {

        public EditableTestContainer() {
            super(Inventory.INVENTORY_CAPACITY, StackingPolicy.INHERITED);
        }

    }

}
