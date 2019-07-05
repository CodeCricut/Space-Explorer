package model.randomGenerators;

import model.elements.*;
import model.items.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class ItemGenerator {
    private static ArrayList<Item> universeItems = new ArrayList<>();

    public static Item generateItem(){
        if (universeItems.isEmpty()){
            addUniverseItems();
        }
        Random rand = new Random();
        return universeItems.get(rand.nextInt(universeItems.size()));
    }

    public static ArrayList<Item> generateMultipleItems(){
        ArrayList<Item> items = new ArrayList<>();
        if (universeItems.isEmpty()){
            addUniverseItems();
        }

        Random random = new Random();
        int numOfItems = random.nextInt(universeItems.size());
        for (int i = 0; i < numOfItems; i++){
            items.add(generateItem());
        }
        return items;
    }


    public static void addUniverseItems(){
        universeItems.add(new MoonRover());
        universeItems.add(new QuantumFizz());
        universeItems.add(new StarCommunicator());
        universeItems.add(new FuelCartridge());
    }

}
