package model.items;

import exceptions.ItemDoesNotExist;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum ItemEnum {
    MOON_ROVER("Moon Rover", 20),
    QUANTUM_FIZZ("Quantum Fizz", 30),
    STAR_COMMUNICATOR("Star Communicator", 50),
    FUEL_CARTRIDGE("Fuel Cartridge", 100);

    //Item Fields, Constructor, and Getters

    private String name;
    private float worth;

    ItemEnum(String name, float worth){
        this.name = name;
        this.worth = worth;
    }

    public String getName() {
        return name;
    }

    public float getWorth() {
        return worth;
    }

    //ItemEnum Static Fields and Getters

    private static final List<ItemEnum> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));

    public static List<ItemEnum> getValues(){
        return VALUES;
    }

    //Converters

    public static ItemEnum convertItemNameToEnum(String itemName) throws ItemDoesNotExist {
        for (ItemEnum itemEnum : ItemEnum.VALUES){
            if (itemEnum.getName().equals(itemName))
                return itemEnum;
        }
        throw new ItemDoesNotExist();
    }

    public static Item convertItemEnumToItem(ItemEnum itemEnum){
        return new Item(itemEnum.getName(), itemEnum.getWorth());
    }
}
