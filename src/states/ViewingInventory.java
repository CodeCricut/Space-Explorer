package states;

import model.utilities.Delimiter;
import ui.Game;

public class ViewingInventory extends State {
    @Override
    public void advance() {
        Delimiter.printCharDelimiter('=');
        System.out.println("Money | $" + Game.getPlayer().getMoney());
        printShipInfo();
        System.out.println("\nPlayer:");
        Game.getPlayer().getInventory().listItems();

        while(ViewingInventory.class == Game.getState().getClass()) {
            presentOptions();
            processOption();
        }

        Delimiter.printCharDelimiter('=');
    }

    private void presentOptions() {
        System.out.println("1. Continue Exploring");
        System.out.println("2. Use Consumable");
    }

    private void processOption() {
        String input = Game.askForUserInput("> ");
        switch (input){
            case "1":
                Game.setState(new PlanetIdling());
                return;
            case "2":
                Game.setState(new UsingConsumable());
                return;
            default:
                System.out.println("Invalid input.");

        }
    }


    private void printShipInfo() {
        Delimiter.printCharDelimiter('-');
        System.out.println("Ship: ");
        System.out.println("Fuel | " + Game.getShip().getCurrFuel());
        if (Game.getShip().canTakeOff()){
            System.out.println("Ready to takeoff.");
        }
        else {
            System.out.println("Insufficient fuel cartridges.");
        }
    }
}
