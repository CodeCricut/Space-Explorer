package model.people;

import exceptions.NotEnoughItemsException;
import model.Inventory;
import model.factories.ItemFactory;
import model.items.Item;
import model.factories.TreasureFactory;

import java.util.ArrayList;

public class Trader extends Person{
    private Inventory inventory;

    public Trader(){
        inventory = new Inventory();
        ArrayList<Item> inventoryItems = ItemFactory.generateMultipleItems();
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
