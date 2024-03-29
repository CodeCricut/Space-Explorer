package states;

import exceptions.ItemDoesNotExist;
import model.Inventory;
import model.factories.ItemFactory;
import model.items.Item;
import model.items.treasures.TreasureEnum;
import model.utilities.Delimiter;
import model.utilities.TimeDelayer;
import ui.Game;

public class PlayerByShip extends State {
    @Override
    public void advance() {
        Delimiter.printCharDelimiter('>');
        System.out.println("You are now at your ship...");
        System.out.println("Depositing fuel-cartridges...");
        Inventory inventory = Game.getPlayer().getInventory();
        Item fuelCartridge;
        try {
            fuelCartridge = ItemFactory.convertItemNameToItem("Fuel Cartridge");
        } catch (ItemDoesNotExist itemDoesNotExist) {
            itemDoesNotExist.printStackTrace();
            return;
        }
        int fuelInInventory = inventory.useAllOfItem(fuelCartridge);
        Game.getShip().depositFuel(fuelInInventory);
        TimeDelayer.delaySeconds();
        if (! Game.getShip().canTakeOff()){
            System.out.println("Your ship does not have enough fuel to takeoff.");
            Game.setState(new PlanetIdling());
            Delimiter.printCharDelimiter('>');
            return;
        }
        confirmTakeoff();
    }

    private void confirmTakeoff() {
        System.out.println("Your ship has enough fuel to takeoff.");
        System.out.println("What would you like to do?");
        System.out.println("1. Takeoff");
        System.out.println("2. Continue exploring " + Game.getPlanet().getName());

        String playerDecision = Game.askForUserInput("> ");

        switch (playerDecision) {
            case "1":
                Game.setState(new Takeoff());
                break;
            case "2":
                Game.setState(new PlanetIdling());
                break;

        }
        Delimiter.printCharDelimiter('>');
    }
}
