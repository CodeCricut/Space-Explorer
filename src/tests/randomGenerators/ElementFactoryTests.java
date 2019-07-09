package tests.randomGenerators;

import model.items.elements.Element;
import model.items.elements.ElementEnum;
import model.factories.ElementFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ui.Game;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class ElementFactoryTests {

    @BeforeAll
    static void setup() {
        Game.initializeGame();
    }

    @Test
    void testGenerateCommonElements(){
        for (int i = 0; i < 100; i++) {
            HashSet<Element> elements = ElementFactory.generateMultipleElements();
            assertTrue(elements.size() <= ElementEnum.getValues().size());
            assertTrue(elements.size() > 0);
        }
    }

}
