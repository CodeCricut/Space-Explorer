package states;

import model.utilities.Delimiter;
import model.utilities.TimeDelayer;
import states.encounters.*;
import ui.Game;

import java.util.Random;

public class ExploringPlanet extends State {
    @Override
    public void advance() {
        Random random = new Random();
        Delimiter.printCharDelimiter('#');
        System.out.println("You are now exploring the planet.");
        Delimiter.printCharDelimiter('#');
        TimeDelayer.delaySeconds();


        int randomInt = random.nextInt(5);
        Game.setState(new Trading());
        switch (randomInt){
            case 0:
                Game.setState(new Fighting());
                break;
            case 1:
               Game.setState(new GettingTreasure());
                break;
            case 2:
                Game.setState(new ExtractingElements());
                break;
            case 3:
                Game.setState(new Trading());
                break;
            case 4:
                Game.setState(new Healing());
                break;
        }
    }
}
