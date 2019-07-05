package states;

import model.Planet;
import model.elements.Element;
import model.planetTypes.PlanetType;
import model.utilities.Delimiter;
import model.utilities.TimeDelayer;
import ui.Game;

import java.util.ArrayList;

public class FindingNewPlanet extends State {
    @Override
    public void advance() {
        Delimiter.printCharDelimiter('-');
        System.out.println("Finding new planet to land on...");
        TimeDelayer.delaySeconds();
        Planet newPlanet = new Planet();
        System.out.println("Found suitable planet.");
        ListPlanetProperties(newPlanet);
        Delimiter.printCharDelimiter('-');

        Delimiter.printEmtpyLines(3);

        Delimiter.printCharDelimiter('?');
        System.out.println("\nWould you like to land?");
        System.out.println("1. Land");
        System.out.println("2. Find a new planet");

        String input = Game.askForUserInput("> ");
        switch (input){
            case "1":
                Game.setPlanet(newPlanet);
                Game.setState(new ArrivingOnPlanet());
                break;
            case "2":
                Game.setState(new FindingNewPlanet());
                break;
        }
        Delimiter.printCharDelimiter('?');
        return;
    }

    private void ListPlanetProperties(Planet planet) {
        PlanetType type = planet.getType();
        Delimiter.printCharDelimiter('@');
        System.out.println("``  `   \\   Name: " + planet.getName());
        System.out.println("`  `  @  |  Planet Type: " + type.getName());
        System.out.println(" `   ` ` |  Planet Description: " + type.getDescription());
        System.out.println("  @` `  /   Max Temperature: " + type.getMaxTemp());
        System.out.println("`_`__--`    Min Temperature: " + type.getMinTemp());
        System.out.println("            Current Temperature: " + planet.getCurrTemp());

        PrintPlanetElements(planet);
        Delimiter.printCharDelimiter('@');
    }

    private void PrintPlanetElements(Planet planet) {
        System.out.println("Common Elements: ");

        ArrayList<Element> planetElements = planet.getElements();
        for(int i = 0; i < planetElements.size(); i++){
            System.out.print("\t");
            System.out.println(planetElements.get(i).getName() + " | $" + planetElements.get(i).getWorth());
        }
    }
}
