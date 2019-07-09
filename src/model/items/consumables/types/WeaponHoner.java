package model.items.consumables.types;

import model.items.consumables.Consumable;
import ui.Game;

public class WeaponHoner extends Consumable {
    private static int damageIncrease = 5;
    private static String description = "Increases weapon damage by " + damageIncrease;
    private static float worth = 25;

    public WeaponHoner() {
        super("Weapon Honer", description, worth);
    }

    @Override
    public void consume() {
        Game.getPlayer().getWeapon().increaseDamage(damageIncrease);
    }
}
