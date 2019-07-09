package model.factories;

import exceptions.ItemDoesNotExist;
import model.items.Item;
import model.items.consumables.Consumable;
import model.items.consumables.ConsumableEnum;
import model.items.elements.Element;
import model.items.treasures.Treasure;
import model.items.treasures.TreasureEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemFactory {

    private static Random random = new Random();

    public static Item createRandomTreasureOrConsumable(){
        int pick = random.nextInt(2);
        if (pick == 0){
            return TreasureFactory.generateTreasure();
        }
        return ConsumableFactory.generateConsumable();
    }

    private static Item createRandomItem(){
        int pick = random.nextInt(3);
        switch (pick){
            case 0:
                return ElementFactory.generateElement();
            case 1:
                return ConsumableFactory.generateConsumable();
            default:
                return TreasureFactory.generateTreasure();
        }
    }

    public static ArrayList<Item> generateMultipleItems(){
        ArrayList<Item> items = new ArrayList<>();
        int totalItems = ConsumableEnum.getValues().size() +
                TreasureEnum.getValues().size() +
                ConsumableEnum.getValues().size();
        int numOfItems = random.nextInt(totalItems) + 1;
        for (int i = 0; i < numOfItems; i++){
            items.add(createRandomItem());
        }
        return items;
    }

    public static Item convertItemNameToItem(String itemName) throws ItemDoesNotExist {
        Item item;
        try {
            item = TreasureFactory.convertTreasureNameToTreasure(itemName);
        } catch (ItemDoesNotExist itemNotATreasure) {
            try {
                item = ConsumableFactory.convertConsumableNameToConsumable(itemName);
            } catch (ItemDoesNotExist itemNotAConsumable) {
                item = ElementFactory.convertElementNameToElement(itemName);
            }
        }
        return item;
    }
}
