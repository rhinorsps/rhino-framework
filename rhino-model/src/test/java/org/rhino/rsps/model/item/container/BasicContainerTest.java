package org.rhino.rsps.model.item.container;

import org.junit.Assert;
import org.junit.Test;
import org.rhino.rsps.model.item.Item;
import org.rhino.rsps.model.item.TestItem;
import org.rhino.rsps.model.item.container.impl.Inventory;

public class BasicContainerTest {

    private static final Item TEST_ITEM_NON_STACKABLE = new TestItem(4151, false);
    private static final Item TEST_ITEM_STACKABLE = new TestItem(995, true);

    @Test
    public void testAddSingleNonStackable() {
        BasicContainer inventory = new BasicContainer();

        Assert.assertTrue(inventory.add(TEST_ITEM_NON_STACKABLE, 1));
        Assert.assertEquals(1, inventory.count(TEST_ITEM_NON_STACKABLE));
        Assert.assertEquals(27, inventory.available());
    }

    @Test
    public void testAddMultipleNonStackable() {
        BasicContainer inventory = new BasicContainer();

        Assert.assertTrue(inventory.add(TEST_ITEM_NON_STACKABLE, 4));
        Assert.assertEquals(4, inventory.count(TEST_ITEM_NON_STACKABLE));
        Assert.assertEquals(24, inventory.available());
    }

    @Test
    public void testAddSingleStackable() {
        BasicContainer inventory = new BasicContainer();

        Assert.assertTrue(inventory.add(TEST_ITEM_STACKABLE, 1));
        Assert.assertEquals(1, inventory.count(TEST_ITEM_STACKABLE));
        Assert.assertEquals(27, inventory.available());
    }

    @Test
    public void testAddMultipleStackable() {
        BasicContainer inventory = new BasicContainer();

        Assert.assertTrue(inventory.add(TEST_ITEM_STACKABLE, 100));
        Assert.assertEquals(100, inventory.count(TEST_ITEM_STACKABLE));
        Assert.assertEquals(27, inventory.available());
    }

    @Test
    public void testClearInventory() {
        BasicContainer inventory = new BasicContainer();

        Assert.assertTrue(inventory.add(TEST_ITEM_NON_STACKABLE, inventory.capacity()));
        Assert.assertTrue(inventory.isFull());
        Assert.assertFalse(inventory.isEmpty());

        inventory.clear();

        Assert.assertFalse(inventory.isFull());
        Assert.assertTrue(inventory.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        BasicContainer inventory = new BasicContainer();

        Assert.assertFalse(inventory.isFull());
        Assert.assertTrue(inventory.isEmpty());
    }

    @Test
    public void testAvailable() {
        BasicContainer inventory = new BasicContainer();

        Assert.assertEquals(inventory.capacity(), inventory.available());
        for (int i = 0; i < inventory.capacity(); i++) {
            Assert.assertTrue(inventory.add(TEST_ITEM_NON_STACKABLE, 1));
            Assert.assertEquals(inventory.capacity() - i - 1, inventory.available());
        }
    }

    @Test
    public void testDeleteSingle() {
        BasicContainer inventory = new BasicContainer();

        Assert.assertTrue(inventory.add(TEST_ITEM_NON_STACKABLE, 1));
        Assert.assertEquals(1, inventory.count(TEST_ITEM_NON_STACKABLE));
        Assert.assertEquals(27, inventory.available());

        Assert.assertTrue(inventory.remove(TEST_ITEM_NON_STACKABLE, 1));
        Assert.assertTrue(inventory.isEmpty());
    }

    @Test
    public void testDeleteMultiple() {
        BasicContainer inventory = new BasicContainer();

        Assert.assertTrue(inventory.add(TEST_ITEM_NON_STACKABLE, 4));
        Assert.assertEquals(4, inventory.count(TEST_ITEM_NON_STACKABLE));
        Assert.assertEquals(24, inventory.available());

        Assert.assertTrue(inventory.remove(TEST_ITEM_NON_STACKABLE, 4));
        Assert.assertTrue(inventory.isEmpty());
    }

    @Test
    public void testDeleteMultipleStackable() {
        BasicContainer inventory = new BasicContainer();

        Assert.assertTrue(inventory.add(TEST_ITEM_STACKABLE, 100));
        Assert.assertEquals(100, inventory.count(TEST_ITEM_STACKABLE));
        Assert.assertEquals(27, inventory.available());

        Assert.assertTrue(inventory.remove(TEST_ITEM_STACKABLE, 100));
        Assert.assertTrue(inventory.isEmpty());
    }


    private static class BasicContainer extends AbstractContainer {

        public BasicContainer() {
            super(Inventory.INVENTORY_CAPACITY, StackingPolicy.INHERITED);
        }

    }

}
