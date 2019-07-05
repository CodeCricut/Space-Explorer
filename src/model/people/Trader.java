package model.people;

import model.Inventory;
import model.items.Item;
import model.randomGenerators.ItemGenerator;

import java.util.ArrayList;

public class Trader extends Person{
    private Inventory inventory;

    public Trader(){
        inventory = new Inventory();
        ArrayList<Item> inventoryItems = ItemGenerator.generateMultipleItems();
        for (int i = 0; i < inventoryItems.size(); i++){
            inventory.addItems(inventoryItems.get(i), 1);
        }
    }

    public Inventory getInventory() {
        return inventory;
    }
}
