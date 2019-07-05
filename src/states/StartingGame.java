package states;

import model.utilities.Delimiter;
import ui.Game;

public class StartingGame extends State {
    @Override
    public void advance() {
        Delimiter.printEmptyConsole();
        Delimiter.printCharDelimiter('-');
        Game.getPlayer().setName(Game.askForUserInput("What is your name? "));
        Game.setState(new ArrivingOnPlanet());
        Delimiter.printCharDelimiter('-');
    }
}
