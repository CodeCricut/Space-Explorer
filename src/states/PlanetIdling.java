package states;

import model.utilities.Delimiter;
import ui.Game;

public class PlanetIdling extends State {
    @Override
    public void advance() {
        Delimiter.printCharDelimiter('?');
        System.out.println("What would you like to do?");
        System.out.println("1. Explore the planet.");
        System.out.println("2. Launch ship into space.");
        System.out.println("3. View inventory.");
        while (true) {
            String playerInput = Game.askForUserInput("> ");
            switch (playerInput) {
                case "1":
                    Game.setState(new ExploringPlanet());
                    break;
                case "2":
                    Game.setState(new PlayerByShip());
                    break;
                case "3":
                    Game.setState(new ViewingInventory());
                    break;
            }
            Delimiter.printCharDelimiter('?');
            return;
        }
    }
}
