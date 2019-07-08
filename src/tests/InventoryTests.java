package tests;

import model.Inventory;
import model.items.Item;
import model.items.ItemEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTests {

    private Inventory inventory;

    @BeforeEach
    void setup(){
        inventory = new Inventory();
    }

    @Test
    void testAddItemGetItemHasItem(){
        Item moonRover = ItemEnum.convertItemEnumToItem(ItemEnum.MOON_ROVER);
        assertFalse(inventory.hasItem(moonRover));
        inventory.addItems(moonRover, 1);
        assertTrue(inventory.hasItem(moonRover));
        assertEquals(1, inventory.getNumOfItem(moonRover));
    }

    @Test
    void testListItems(){
        inventory.listItems();
        populateInventory();
        inventory.listItems();
    }

    @Test
    void testUseAllAndNumItems(){
        populateInventory();
        int numOfMoonRover = inventory.getNumOfItem(ItemEnum.convertItemEnumToItem(ItemEnum.MOON_ROVER));
        Item moonRover = ItemEnum.convertItemEnumToItem(ItemEnum.MOON_ROVER);
        inventory.useNumOfItem(moonRover, 1);
        assertEquals(numOfMoonRover - 1, inventory.getNumOfItem(ItemEnum.convertItemEnumToItem(ItemEnum.MOON_ROVER)));
        inventory.useAllOfItem(ItemEnum.convertItemEnumToItem(ItemEnum.MOON_ROVER));
        assertFalse(inventory.hasItem(ItemEnum.convertItemEnumToItem(ItemEnum.MOON_ROVER)));

    }

    private void populateInventory() {
        inventory.addItems(ItemEnum.convertItemEnumToItem(ItemEnum.MOON_ROVER), 1);
        inventory.addItems(ItemEnum.convertItemEnumToItem(ItemEnum.MOON_ROVER), 1);
        inventory.addItems(ItemEnum.convertItemEnumToItem(ItemEnum.MOON_ROVER), 1);
        inventory.addItems(ItemEnum.convertItemEnumToItem(ItemEnum.MOON_ROVER), 1);
    }



}
