package model.randomGenerators;

import model.elements.*;
import model.items.*;
import ui.Game;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class ItemGenerator {

    private static ArrayList<Item> universeItemsArray = Game.getUniverseItems();

    public static Item generateItem(){
        Random rand = new Random();
        return universeItemsArray.get(rand.nextInt(universeItemsArray.size()));
    }

    public static ArrayList<Item> generateMultipleItems(){
        ArrayList<Item> items = new ArrayList<>();

        Random random = new Random();
        int numOfItems = random.nextInt(universeItemsArray.size());
        for (int i = 0; i < numOfItems; i++){
            items.add(generateItem());
        }
        return items;
    }
}
