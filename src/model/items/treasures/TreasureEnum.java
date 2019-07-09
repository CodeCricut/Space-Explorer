package model.items.treasures;

import exceptions.ItemDoesNotExist;
import model.items.Item;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum TreasureEnum {
    MOON_ROVER("Moon Rover", 20),
    QUANTUM_FIZZ("Quantum Fizz", 30),
    STAR_COMMUNICATOR("Star Communicator", 50),
    FUEL_CARTRIDGE("Fuel Cartridge", 100);

    //Item Fields, Constructor, and Getters

    Treasure treasure;

    TreasureEnum(String name, float worth){
        treasure = new Treasure(name, worth);
    }

    public Treasure getTreasure() {
        return treasure;
    }

    //TreasureEnum Static Fields and Getters

    private static final List<TreasureEnum> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));

    public static List<TreasureEnum> getValues(){
        return VALUES;
    }

//    //Converters
//
//    public static TreasureEnum convertTreasureNameToTreasure(String itemName) throws ItemDoesNotExist {
//        for (TreasureEnum treasureEnum : TreasureEnum.VALUES){
//            if (treasureEnum.getName().equals(itemName))
//                return treasureEnum;
//        }
//        throw new ItemDoesNotExist();
//    }
//
//    public static Item convertItemEnumToItem(TreasureEnum treasureEnum){
//        return new Item(treasureEnum.getName(), treasureEnum.getWorth());
//    }
}
