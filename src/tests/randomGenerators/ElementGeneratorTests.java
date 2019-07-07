package tests.randomGenerators;

import model.Planet;
import model.elements.Element;
import model.randomGenerators.ElementGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ui.Game;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class ElementGeneratorTests {

    @BeforeAll
    static void setup() {
        Game.initializeGame();
    }

    @Test
    void testGenerateCommonElements(){
        for (int i = 0; i < 100; i++) {
            ArrayList<Element> elements = ElementGenerator.generateCommonElements();
            assertTrue(elements.size() <= 10);
            assertTrue(elements.size() > 0);
        }
    }

    @Test
    void testGenerateOneCommonElement(){
        for (int i = 0; i < 100; i++) {
            Element element = ElementGenerator.generateOneCommonElement();
            if (element == null)
                fail("No random element was generated.");
        }
    }
}
