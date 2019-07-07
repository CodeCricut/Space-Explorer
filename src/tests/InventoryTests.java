package tests;

import model.Inventory;
import model.items.FuelCartridge;
import model.items.MoonRover;
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
        MoonRover moonRover = new MoonRover();
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
        int numOfMoonRover = inventory.getNumOfItem(new MoonRover());
        inventory.useNumOfItem(new MoonRover(), 1);
        assertEquals(numOfMoonRover - 1, inventory.getNumOfItem(new MoonRover()));
        inventory.useAllOfItem(new MoonRover());
        assertFalse(inventory.hasItem(new MoonRover()));

    }

    private void populateInventory() {
        inventory.addItems(new MoonRover(), 1);
        inventory.addItems(new MoonRover(), 1);
        inventory.addItems(new MoonRover(), 1);
        inventory.addItems(new FuelCartridge(), 1);
    }



}
