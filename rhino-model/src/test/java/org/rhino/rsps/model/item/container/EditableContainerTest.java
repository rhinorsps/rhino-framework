package org.rhino.rsps.model.item.container;

import org.junit.Assert;
import org.junit.Test;
import org.rhino.rsps.model.item.Item;
import org.rhino.rsps.model.item.TestItem;
import org.rhino.rsps.model.item.container.inventory.Inventory;

public class InventoryTest {

    private static final Item TEST_ITEM_NON_STACKABLE = new TestItem(4151, false);
    private static final Item TEST_ITEM_STACKABLE = new TestItem(995, true);

    @Test
    public void testAddSingleNonStackable() {
        Inventory inventory = new Inventory();

        Assert.assertTrue(inventory.add(TEST_ITEM_NON_STACKABLE, 1));
        Assert.assertEquals(1, inventory.count(TEST_ITEM_NON_STACKABLE));
        Assert.assertEquals(27, inventory.available());
    }

    @Test
    public void testAddMultipleNonStackable() {
        Inventory inventory = new Inventory();

        Assert.assertTrue(inventory.add(TEST_ITEM_NON_STACKABLE, 4));
        Assert.assertEquals(4, inventory.count(TEST_ITEM_NON_STACKABLE));
        Assert.assertEquals(24, inventory.available());
    }

    @Test
    public void testAddSingleStackable() {
        Inventory inventory = new Inventory();

        Assert.assertTrue(inventory.add(TEST_ITEM_STACKABLE, 1));
        Assert.assertEquals(1, inventory.count(TEST_ITEM_STACKABLE));
        Assert.assertEquals(27, inventory.available());
    }

    @Test
    public void testAddMultipleStackable() {
        Inventory inventory = new Inventory();

        Assert.assertTrue(inventory.add(TEST_ITEM_STACKABLE, 100));
        Assert.assertEquals(100, inventory.count(TEST_ITEM_STACKABLE));
        Assert.assertEquals(27, inventory.available());
    }

    @Test
    public void testClearInventory() {
        Inventory inventory = new Inventory();

        Assert.assertTrue(inventory.add(TEST_ITEM_NON_STACKABLE, inventory.capacity()));
        Assert.assertTrue(inventory.isFull());
        Assert.assertFalse(inventory.isEmpty());

        inventory.clear();

        Assert.assertFalse(inventory.isFull());
        Assert.assertTrue(inventory.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        Inventory inventory = new Inventory();

        Assert.assertFalse(inventory.isFull());
        Assert.assertTrue(inventory.isEmpty());
    }

    @Test
    public void testAvailable() {
        Inventory inventory = new Inventory();

        Assert.assertEquals(inventory.capacity(), inventory.available());
        for (int i = 0; i < inventory.capacity(); i++) {
            Assert.assertTrue(inventory.add(TEST_ITEM_NON_STACKABLE, 1));
            Assert.assertEquals(inventory.capacity() - i - 1, inventory.available());
        }
    }

    @Test
    public void testDeleteSingle() {
        Inventory inventory = new Inventory();

        Assert.assertTrue(inventory.add(TEST_ITEM_NON_STACKABLE, 1));
        Assert.assertEquals(1, inventory.count(TEST_ITEM_NON_STACKABLE));
        Assert.assertEquals(27, inventory.available());

        Assert.assertTrue(inventory.remove(TEST_ITEM_NON_STACKABLE, 1));
        Assert.assertTrue(inventory.isEmpty());
    }

    @Test
    public void testDeleteMultiple() {
        Inventory inventory = new Inventory();

        Assert.assertTrue(inventory.add(TEST_ITEM_NON_STACKABLE, 4));
        Assert.assertEquals(4, inventory.count(TEST_ITEM_NON_STACKABLE));
        Assert.assertEquals(24, inventory.available());

        Assert.assertTrue(inventory.remove(TEST_ITEM_NON_STACKABLE, 4));
        Assert.assertTrue(inventory.isEmpty());
    }

    @Test
    public void testDeleteMultipleStackable() {
        Inventory inventory = new Inventory();

        Assert.assertTrue(inventory.add(TEST_ITEM_STACKABLE, 100));
        Assert.assertEquals(100, inventory.count(TEST_ITEM_STACKABLE));
        Assert.assertEquals(27, inventory.available());

        Assert.assertTrue(inventory.remove(TEST_ITEM_STACKABLE, 100));
        Assert.assertTrue(inventory.isEmpty());
    }

    @Test
    public void testSwap() {
        Inventory inventory = new Inventory();

        Assert.assertTrue(inventory.add(TEST_ITEM_STACKABLE, 100));
        Assert.assertTrue(inventory.add(TEST_ITEM_NON_STACKABLE, 1));

        inventory.swap(0, 1);

        Assert.assertEquals(inventory.get(1), TEST_ITEM_STACKABLE);
        Assert.assertEquals(inventory.get(0), TEST_ITEM_NON_STACKABLE);
    }

}
