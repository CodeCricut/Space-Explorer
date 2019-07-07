package tests.utilities;

import exceptions.ItemAdapterNotAccountedException;
import model.elements.*;
import model.items.Item;
import model.items.MoonRover;
import model.utilities.ItemAdapter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ItemAdapterTests {

    @Test
     void testMakeItemValidInput() throws ItemAdapterNotAccountedException {
        Item item = ItemAdapter.makeItem("Moon Rover");
        assertEquals(new MoonRover().getName(), item.getName());

        item = ItemAdapter.makeItem("Carbon");
        assertEquals(new Carbon().getName(), item.getName());

        item = ItemAdapter.makeItem("Neon");
        assertEquals(new Neon().getName(), item.getName());
    }

    @Test
    void testMakeItemInvalidInput(){
        assertThrows(ItemAdapterNotAccountedException.class, () -> {
            Item invalidItem = ItemAdapter.makeItem("invalid item");
        });
    }
}
