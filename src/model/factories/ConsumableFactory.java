package model.factories;

import exceptions.ItemDoesNotExist;
import model.items.consumables.Consumable;
import model.items.consumables.ConsumableEnum;
import java.util.List;
import java.util.Random;

public class ConsumableFactory {

    private static final List<ConsumableEnum> VALUES = ConsumableEnum.getValues();
    private static final int SIZE = VALUES.size();

    private static final Random RANDOM = new Random();

    static Consumable generateConsumable() {
        return VALUES.get(RANDOM.nextInt(SIZE)).getConsumableType();
    }

    public static Consumable convertConsumableNameToConsumable(String consumableName) throws ItemDoesNotExist {
        for (ConsumableEnum consumableEnum : VALUES){
            Consumable consumable = consumableEnum.getConsumableType();
            if (consumable.getName().equals(consumableName)){
                return consumable;
            }
        }
        throw new ItemDoesNotExist();
    }
}
