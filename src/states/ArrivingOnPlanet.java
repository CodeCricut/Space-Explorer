package states;

import model.utilities.Delimiter;
import model.utilities.TimeDelayer;
import ui.Game;

public class ArrivingOnPlanet extends State {
    @Override
    public void advance() {
        Delimiter.printCharDelimiter('-');
        System.out.println("Now on planet " + Game.getPlanet().getName());
        Game.setState(new PlanetIdling());
        Delimiter.printCharDelimiter('-');
        TimeDelayer.delaySeconds();
    }
}
