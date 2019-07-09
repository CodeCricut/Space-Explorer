package tests;

import exceptions.ItemDoesNotExist;
import model.Inventory;
import model.factories.ItemFactory;
import model.items.Item;
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
    void testAddItemGetItemHasItem() throws ItemDoesNotExist {
        Item moonRover = ItemFactory.convertItemNameToItem("Moon Rover");
        assertFalse(inventory.hasItem(moonRover));
        inventory.addItems(moonRover, 1);
        assertTrue(inventory.hasItem(moonRover));
        assertEquals(1, inventory.getNumOfItem(moonRover));
    }

    @Test
    void testListItems() throws ItemDoesNotExist {
        inventory.listItems();
        populateInventory();
        inventory.listItems();
    }

    @Test
    void testUseAllAndNumItems() throws ItemDoesNotExist {
        populateInventory();
        Item moonRover = ItemFactory.convertItemNameToItem("Moon Rover");
        int numOfMoonRover = inventory.getNumOfItem(moonRover);
        inventory.useNumOfItem(moonRover, 1);
        assertEquals(numOfMoonRover - 1, inventory.getNumOfItem(moonRover));
        inventory.useAllOfItem(moonRover);
        assertFalse(inventory.hasItem(moonRover));

    }

    private void populateInventory() throws ItemDoesNotExist {
        Item moonRover = ItemFactory.convertItemNameToItem("Moon Rover");
        inventory.addItems(moonRover, 1);
        inventory.addItems(moonRover, 1);
        inventory.addItems(moonRover, 1);
        inventory.addItems(moonRover, 1);
    }



}
