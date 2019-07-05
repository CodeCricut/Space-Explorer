package states;

import states.encounters.*;
import ui.Game;

public class Debugging extends State {
    @Override
    public void advance() {
        System.out.println("Which state would you like to test?");
        System.out.println("1. Arriving on Planet\n" +
                "2. Exploring Planet\n" +
                "3. Finding New Planet\n" +
                "4. Planet Idling\n" +
                "5. Player By Ship\n" +
                "6. Starting Game\n" +
                "7. Takeoff\n" +
                "8. Viewing Inventory\n" +
                "9. Healing\n" +
                "10.Trading\n" +
                "11.Extracting Elements\n" +
                "12. Fighting\n" +
                "13. Getting Treasure");

        String input = Game.askForUserInput("State > ");

        while (true) {
            switch (input) {
                case "1":
                    Game.setState(new ArrivingOnPlanet());
                    return;
                case "2":
                    Game.setState(new ExploringPlanet());
                    return;
                case "3":
                    Game.setState(new FindingNewPlanet());
                    return;
                case "4":
                    Game.setState(new PlanetIdling());
                    return;
                case "5":
                    Game.setState(new PlayerByShip());
                    return;
                case "6":
                    Game.setState(new StartingGame());
                    return;
                case "7":
                    Game.setState(new Takeoff());
                    return;
                case "8":
                    Game.setState(new ViewingInventory());
                    return;
                case "9":
                    Game.setState(new Healing());
                    return;
                case "10":
                    Game.setState(new Trading());
                    return;
                case "11":
                    Game.setState(new ExtractingElements());
                    return;
                case "12":
                    Game.setState(new Fighting());
                    return;
                case "13":
                    Game.setState(new GettingTreasure());
                    return;
            }
        }
    }
}