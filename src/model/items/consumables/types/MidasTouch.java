package model.items.consumables.types;

import model.items.consumables.Consumable;
import ui.Game;

public class MidasTouch extends Consumable {

    private static int moneyIncrease = 50;
    private static String description = "Instantly grants you $" + moneyIncrease;
    public MidasTouch() {
        super("Midas Touch", description, moneyIncrease / 2);
    }

    @Override
    public void consume() {
        Game.getPlayer().depositFunds(moneyIncrease);
    }
}
