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
        Game.askForUserInput("Press 'Enter' to continue");
        Game.setState(new PlanetIdling());
        Delimiter.printCharDelimiter('=');
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
