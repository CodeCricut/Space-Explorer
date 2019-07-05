package states;

import model.utilities.Delimiter;
import model.utilities.TimeDelayer;
import ui.Game;

public class Takeoff extends State {
    @Override
    public void advance() {
        Delimiter.printCharDelimiter('"');
        System.out.println("Now taking off...");
        Game.getShip().takeOff();
        Game.setState(new FindingNewPlanet());
        Delimiter.printCharDelimiter('"');
        TimeDelayer.delaySeconds();
    }
}
