package states.encounters;

import model.people.Player;
import model.utilities.Delimiter;
import model.utilities.TimeDelayer;
import states.ExploringPlanet;
import states.State;
import ui.Game;

public class Healing extends State {
    @Override
    public void advance() {
        Player player = Game.getPlayer();
        float moneyRequiredToHeal = player.getMaxHealth() - player.getCurrHealth();

        Delimiter.printCharDelimiter('^');
        System.out.println("You encountered a healer!");
        System.out.println("Do you wish to heal yourself for $" + moneyRequiredToHeal);
        System.out.println("1. Heal");
        System.out.println("2. Continue Exploring");

        String input = Game.askForUserInput("> ");

        if (input.equals("1")){
            healPlayer(player, moneyRequiredToHeal);
        }
        Game.setState( new ExploringPlanet());
        Delimiter.printCharDelimiter('^');
    }

    private void healPlayer(Player player, float moneyRequiredToHeal) {
        if (player.getMoney() < moneyRequiredToHeal){
            System.out.println("You do not have enough money to heal.");
            return;
        }
        System.out.println("Healing...");
        TimeDelayer.delaySeconds();
        player.setCurrHealth(player.getMaxHealth());
        player.withdrawalFunds(moneyRequiredToHeal);
    }
}
