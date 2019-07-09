package states.encounters;

import model.factories.TreasureFactory;
import model.utilities.Delimiter;
import model.utilities.TimeDelayer;
import model.items.Item;
import states.PlanetIdling;
import states.State;
import ui.Game;

public class GettingTreasure extends State {
    @Override
    public void advance() {
        Delimiter.printCharDelimiter('$');

        retrieveTreasure();
        Game.setState(new PlanetIdling());

        Delimiter.printCharDelimiter('$');
        TimeDelayer.delaySeconds();
    }

    private void retrieveTreasure() {
        System.out.println("You found treasure!");
        Item treasure = TreasureFactory.generateTreasure();
        System.out.println("It is a " + treasure.getName() + ".");
        System.out.println("Adding item to inventory...");
        Game.getPlayer().getInventory().addItems(treasure, 1);
    }
}
