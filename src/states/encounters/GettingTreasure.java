package states.encounters;

import model.randomGenerators.ItemGenerator;
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
        System.out.println("You found treasure!");
        Item treasure = ItemGenerator.generateItem();
        System.out.println("It is a " + treasure.getName() + ".");
        System.out.println("Adding item to inventory...");
        Game.getPlayer().getInventory().addItems(treasure, 1);
        Game.setState(new PlanetIdling());
        Delimiter.printCharDelimiter('$');
        TimeDelayer.delaySeconds();
    }
}
