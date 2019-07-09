package model.factories;

import exceptions.ItemDoesNotExist;
import model.items.elements.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class ElementFactory {

    private static final List<ElementEnum> VALUES = ElementEnum.getValues();
    private static final int SIZE = VALUES.size();

    private static final Random RANDOM = new Random();

    public static Element generateElement() {
        return VALUES.get(RANDOM.nextInt(SIZE)).getElement();
    }

    static Element convertElementNameToElement(String elementName) throws ItemDoesNotExist {
        for (ElementEnum elementEnum : VALUES){
            Element element = elementEnum.getElement();
            if (element.getName().equals(elementName)){
                return element;
            }
        }
        throw new ItemDoesNotExist();
    }

    public static HashSet<Element> generateMultipleElements(){
        HashSet<Element> elements = new HashSet<>();
        Random random = new Random();
        int numOfItems = random.nextInt(SIZE) + 1;
        for (int i = 0; i < numOfItems ; i++){
            elements.add(generateElement());
        }
        return elements;
    }
}
