package model.factories;

import exceptions.ItemDoesNotExist;
import model.items.treasures.Treasure;
import model.items.treasures.TreasureEnum;
import model.items.elements.ElementEnum;
import model.items.Item;

import java.util.*;

public class TreasureFactory {

    private static final List<TreasureEnum> VALUES = TreasureEnum.getValues();
    private static final int SIZE = VALUES.size();

    private static final Random RANDOM = new Random();

   public static Treasure generateTreasure(){
       return VALUES.get(RANDOM.nextInt(SIZE)).getTreasure();
   }

   public static Treasure convertTreasureNameToTreasure(String treasureName) throws ItemDoesNotExist {
       for (TreasureEnum treasureEnum : VALUES){
           Treasure treasure = treasureEnum.getTreasure();
           if (treasure.getName().equals(treasureName)){
               return treasure;
           }
       }
       throw new ItemDoesNotExist();
   }
}
