package model.items.consumables;

import model.items.consumables.types.HealingConsumable;
import model.items.consumables.types.WeaponHoner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum ConsumableEnum {
    HEALING_POTION(new HealingConsumable()),
    WEAPON_Honer(new WeaponHoner());

    //Consumable Fields, Constructor, and Getters

    private Consumable consumableType;

    ConsumableEnum(Consumable consumable){
        consumableType = consumable;
    }

    public Consumable getConsumableType() {
        return consumableType;
    }

    //Static ConsumableEnum Fields and Getters

    private static final List<ConsumableEnum> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));

    public static List<ConsumableEnum> getValues(){
        return VALUES;
    }
}
