package states.encounters;

import model.utilities.Delimiter;
import model.utilities.TimeDelayer;
import model.elements.Element;
import model.randomGenerators.ElementGenerator;
import states.PlanetIdling;
import states.State;
import ui.Game;

public class ExtractingElements extends State {
    @Override
    public void advance() {
        Delimiter.printCharDelimiter('*');

        Element elementType = ElementGenerator.generateElement();
        presentOptions(elementType);
        processUserOption(elementType);

        Delimiter.printCharDelimiter('*');
    }

    //User Option Methods

    private void presentOptions(Element elementType) {
        System.out.println("You found an element deposit.");
        System.out.println("Type: " + elementType.getName() +
                " | Atomic Num: " + elementType.getAtomicNumber() +
                " | Worth: " + elementType.getWorth());
        System.out.println("Do you wish to mine it?");
        System.out.println("1. Mine the deposit.");
        System.out.println("2. Continue exploring");
    }

    private void processUserOption(Element elementType) {
        String input = Game.askForUserInput("> ");
        switch (input){
            case "1":
                mineDeposit(elementType);
                Game.setState(new PlanetIdling());
                return;
            case "2":
                Game.setState(new PlanetIdling());
                return;
        }
        presentOptions(elementType);
    }

    private void mineDeposit(Element element) {
        System.out.print("Mining deposit");
        int timeToMine = (int) element.getWorth() / 10;
        for (int i = 0; i < timeToMine; i++){
            System.out.print(".");
            TimeDelayer.delaySeconds();
        }
        System.out.println("\n" + element.getName() + " added to inventory.");
        Game.getPlayer().getInventory().addItems(element, 1);
    }
}
