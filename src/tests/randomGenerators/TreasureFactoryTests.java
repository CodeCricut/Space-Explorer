package tests.randomGenerators;

import exceptions.ItemDoesNotExist;
import model.items.Item;
import model.factories.TreasureFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TreasureFactoryTests {

    @Test
    void testGenerateItem(){
        for (int i = 0; i < 100; i++){
            Item item = TreasureFactory.generateTreasure();
            assertNotNull(item);
        }
    }

    @Test
    void testConvertItemNameToItemShouldNotThrowException() throws ItemDoesNotExist {
        String treasureName = "Moon Rover";
        Item moonRover = TreasureFactory.convertTreasureNameToTreasure(treasureName);
    }

    @Test
    void testConvertItemNameToItemShouldThrowException(){
        String treasureName = "Invalid Item";
        assertThrows(ItemDoesNotExist.class, () -> TreasureFactory.convertTreasureNameToTreasure(treasureName));
    }
}
