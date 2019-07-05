package model;

import model.items.Item;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Inventory {
    private HashMap<Item, Integer> items = new HashMap<>(); //item name, quantity


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

    public int getNumOfItem(Item item){
        if (!items.containsKey(item)){
            return 0;
        }
        return items.get(item);
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

    public void useOneItem(String itemName) {
        useNumOfItem(itemName, 1);
    }

    public void useNumOfItem(String itemName, int numToUse){
        Iterator<Map.Entry<Item, Integer>> iterator = items.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Item, Integer> entry = iterator.next();
            if (itemName.equals(entry.getKey().getName())){
                entry.setValue(entry.getValue() - numToUse);
                cleanItems();
                break;
            }
        }
    }

    public boolean hasItem(String itemName){
        for (Item item : items.keySet()){
            if (item.getName().equals(itemName))
                return true;
        }
        return false;
    }

    public int useAllOfItem(String itemName){
            for (Item invItems : items.keySet()){
                if (itemName.equals(invItems.getName())){
                    int itemQuantity = items.get(invItems);
                    items.remove(invItems);
                    return itemQuantity;
                }
            }
        return 0;
    }

    public void cleanItems(){
        Iterator<Map.Entry<Item, Integer>> iterator = items.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Item, Integer> entry = iterator.next();
            if (entry.getValue() == 0){
                iterator.remove();
            }
        }
    }
}
