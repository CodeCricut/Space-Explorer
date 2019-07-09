package model;

import model.items.Item;
import model.items.consumables.Consumable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Inventory {
    private HashMap<Item, Integer> items = new HashMap<>(); //item name, quantity

    //Modifiers

    public void addItems(Item item, int numToAdd){
        String itemName = item.getName();
        for (Item invItem : items.keySet()){
            if (itemName.equals(invItem.getName())){
                items.put(invItem, items.get(invItem) + numToAdd);
                return;
            }
        }
        items.put(item, numToAdd);
    }

    public void useNumOfItem(Item item, int numToUse){
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            if (item.getName().equals(entry.getKey().getName())) {
                entry.setValue(entry.getValue() - numToUse);
                cleanItems();
                break;
            }
        }
    }

    public int useAllOfItem(Item item){
        for (Item invItems : items.keySet()){
            if (item.getName().equals(invItems.getName())){
                int itemQuantity = items.get(invItems);
                items.remove(invItems);
                return itemQuantity;
            }
        }
        return 0;
    }

    private void cleanItems(){
        items.entrySet().removeIf(entries->entries.getValue() == 0);
    }

    //Getters/List/HasItem

    public int getNumOfItem(Item item){
        for (Item itemInInv : items.keySet()){
            if (itemInInv.getName().equals(item.getName())){
                return items.get(itemInInv);
            }
        }
        return 0;
    }

    public void listItems(){
        if(items.isEmpty()){
            System.out.println("\tInventory Empty");
            return;
        }
        for(Map.Entry<Item, Integer> entry : items.entrySet()){
            System.out.println("\t" + entry.getKey().getName() + " | Quantity: " + entry.getValue() + " | Value: " + entry.getKey().getWorth());
        }
    }

    public void listConsumables(){
        boolean consumablePresent = false;
        for (Map.Entry<Item, Integer> entry : items.entrySet()){
            Item item = entry.getKey();
            if (item instanceof Consumable){
                System.out.println("\t" + item.getName() + " | Quantity: " + entry.getValue() + " | Value: $" + item.getWorth());
                System.out.println("\t\tDescription: " + ((Consumable) item).getDescription());
                consumablePresent = true;
            }
        }
        if (! consumablePresent){
            System.out.println("\tNo consumables in inventory");
        }
    }

    public boolean hasItem(Item item){
        for (Item invItem : items.keySet()){
            if (item.getName().equals(invItem.getName()))
                return true;
        }
        return false;
    }

}
