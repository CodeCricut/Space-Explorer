package model.items.consumables.types;

import model.items.consumables.Consumable;
import ui.Game;

public class HealingConsumable extends Consumable {

    private static int healthToRestore = 10;

    private static String name;
    private static String description = "Restores " + healthToRestore + " health.";

    public HealingConsumable() {
        super("Healing Potion", description, healthToRestore);
    }

    @Override
    public void consume() {
        Game.getPlayer().restoreHealth(healthToRestore);
    }
}
