package model.randomGenerators;

import exceptions.ItemDoesNotExist;
import model.elements.*;
import model.items.Item;
import model.items.ItemEnum;
import ui.Game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class ElementGenerator {

    private static final List<ElementEnum> VALUES = ElementEnum.getValues();
    private static final int SIZE = VALUES.size();

    private static final Random RANDOM = new Random();

    public static Element generateElement() {
        return ElementEnum.convertElementEnumToElement(VALUES.get(RANDOM.nextInt(SIZE)));
    }

    public static Element convertElementNameToItem(String elementName) throws ItemDoesNotExist {
        ElementEnum elementEnum = ElementEnum.convertElementNameToEnum(elementName);
        return ElementEnum.convertElementEnumToElement(elementEnum);
    }

    public static ArrayList<Element> generateMultipleElements(){
        ArrayList<Element> elements = new ArrayList<>();
        Random random = new Random();
        int numOfItems = random.nextInt(SIZE) + 1;
        for (int i = 0; i < numOfItems ; i++){
            elements.add(generateElement());
        }
        return elements;
    }
}
