package model.items.elements;

import exceptions.ItemDoesNotExist;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum ElementEnum {
    //Worth derived from commonality in the universe
    HYDROGEN("Hydrogen", 5, 1),
    HELIUM("Helium", 10, 2),
    OXYGEN("Oxygen", 15, 8),
    CARBON("Carbon", 20, 6),
    NEON("Neon", 25, 10),
    NITROGEN("Nitrogen", 30, 7),
    MAGNESIUM("Magnesium", 35, 12),
    SILICON("Silicon", 40, 14),
    IRON("Iron", 45, 26),
    SULFUR("Sulfur", 50, 16);

    //Element Fields, Constructor, and Getters

    Element element;

    ElementEnum(String name, float worth, int atomicNum){
        element = new Element(name, worth, atomicNum);
    }

    public Element getElement() {
        return element;
    }

    //ElementEnum Static Fields and Getters

    private static final List<ElementEnum> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));

    public static List<ElementEnum> getValues(){
        return VALUES;
    }

//    //Converters
//
//    public static ElementEnum convertElementNameToEnum(String itemName) throws ItemDoesNotExist {
//        for (ElementEnum elementEnum : ElementEnum.VALUES){
//            if (elementEnum.getName().equals(itemName))
//                return elementEnum;
//        }
//        throw new ItemDoesNotExist();
//    }
//
//    public static Element convertElementEnumToElement(ElementEnum elementEnum){
//        return new Element(elementEnum.getName(), elementEnum.getWorth(), elementEnum.getAtomicNum());
//    }
}
