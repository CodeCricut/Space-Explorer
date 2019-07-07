package tests.randomGenerators;

import model.items.Item;
import model.randomGenerators.ItemGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ItemGeneratorTests {

    @Test
    void testGenerateItem(){
        for (int i = 0; i < 100; i++){
            Item item = ItemGenerator.generateItem();
            assertNotNull(item);
        }
    }

    @Test
    void testGenerateMultipleItems(){
        for (int i = 0; i < 100; i++){
            ArrayList<Item> items = ItemGenerator.generateMultipleItems();
            assertNotNull(items);
        }
    }
}
