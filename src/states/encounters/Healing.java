package states.encounters;

import exceptions.NotEnoughMoneyException;
import model.people.Player;
import model.utilities.Delimiter;
import model.utilities.TimeDelayer;
import states.ExploringPlanet;
import states.PlanetIdling;
import states.State;
import ui.Game;

public class Healing extends State {
    private Player player = Game.getPlayer();

    @Override
    public void advance() {
        Delimiter.printCharDelimiter('^');

        float moneyRequiredToHeal = player.getMaxHealth() - player.getCurrHealth();
        while(Healing.class.equals(Game.getState().getClass())) {
            presentOptions(moneyRequiredToHeal);
            processOption(moneyRequiredToHeal);
        }

        Delimiter.printCharDelimiter('^');
    }

    //User Option Methods

    private void presentOptions(float moneyRequiredToHeal) {
        System.out.println("You encountered a healer!");
        System.out.println("Do you wish to heal yourself for $" + moneyRequiredToHeal);
        System.out.println("1. Heal");
        System.out.println("2. Continue Exploring");
    }

    private void processOption(float moneyRequiredToHeal) {
        String input = Game.askForUserInput("> ");
        switch (input){
            case "1":
                healPlayer(moneyRequiredToHeal);
                Game.setState(new PlanetIdling());
                break;
            case "2":
                Game.setState(new PlanetIdling());
                break;
            default:
                System.out.println("Invalid input.");
        }
    }

    private void healPlayer(float moneyRequiredToHeal) {
        try {
            player.withdrawalFunds(moneyRequiredToHeal);
            player.setCurrHealth(player.getMaxHealth());
            System.out.println("Healing...");
            TimeDelayer.delaySeconds();
        } catch (NotEnoughMoneyException e) {
            System.out.println("You do not have enough money to heal.");
        }
    }
}
