package model.randomGenerators;

import exceptions.ItemDoesNotExist;
import model.elements.ElementEnum;
import model.items.Item;
import model.items.ItemEnum;

import java.util.*;

public class ItemGenerator {

    private static final List<ItemEnum> VALUES = ItemEnum.getValues();
    private static final int SIZE = VALUES.size();

    private static final Random RANDOM = new Random();

    public static Item generateItem() {
        return ItemEnum.convertItemEnumToItem(VALUES.get(RANDOM.nextInt(SIZE)));
    }

    public static Item convertItemNameToItem(String itemName) throws ItemDoesNotExist {
        try {//Try converting string to item, not element
            ItemEnum itemEnum = ItemEnum.convertItemNameToEnum(itemName);
            return ItemEnum.convertItemEnumToItem(itemEnum);
        } catch (ItemDoesNotExist itemDoesNotExist) { //try converting to element instead of item
            return ElementEnum.convertElementEnumToElement(ElementEnum.convertElementNameToEnum(itemName));
        }
    }

    public static ArrayList<Item> generateMultipleItems(){
        ArrayList<Item> items = new ArrayList<>();
        Random random = new Random();
        int numOfItems = random.nextInt(SIZE);
        for (int i = 0; i < numOfItems; i++){
            items.add(generateItem());
        }
        return items;
    }
}
