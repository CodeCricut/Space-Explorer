package model.people;

import exceptions.NotEnoughItemsException;
import exceptions.NotEnoughMoneyException;
import model.Inventory;
import model.items.Item;
import model.randomGenerators.ItemGenerator;

import java.util.ArrayList;

public class Trader extends Person{
    private Inventory inventory;

    public Trader(){
        inventory = new Inventory();
        ArrayList<Item> inventoryItems = ItemGenerator.generateMultipleItems();
        for (Item inventoryItem : inventoryItems) {
            inventory.addItems(inventoryItem, 1);
        }
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void sellNumOfItem(Item item, int numToSell) throws NotEnoughItemsException {
        int numOfItemInInventory = inventory.getNumOfItem(item);
        if (numToSell > numOfItemInInventory){
            throw new NotEnoughItemsException();
        }
        inventory.useNumOfItem(item, numToSell);
    }
}
