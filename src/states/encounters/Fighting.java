package states.encounters;

import model.utilities.Delimiter;
import model.utilities.TimeDelayer;
import model.people.Enemy;
import model.people.Player;
import states.StartingGame;
import states.State;
import ui.Game;

public class Fighting extends State {
    private Player player = Game.getPlayer();
    private Enemy enemy = new Enemy();

    @Override
    public void advance() {
        Delimiter.printCharDelimiter('X');

        System.out.println("The enemy " + enemy.getName() + " approaches...");
        TimeDelayer.delaySeconds();
        while (player.isAlive() && enemy.isAlive()) {
            fight();
        }
        if (player.isAlive()){
            System.out.println("You won the fight! The enemy had some treasure on it.");
            Game.setState(new GettingTreasure());
        }
        else {
            restartGame();
        }
        Delimiter.printCharDelimiter('X');
    }

    //Helper Methods

    private void printFightersInfo(Player player) {
        System.out.println("Enemy | Health = " + enemy.getCurrHealth() + " | Damage = " + enemy.getWeapon().getDamage());
        System.out.println(player.getName() + " | Health = " + player.getCurrHealth() + " | Damage = " + player.getWeapon().getDamage());
    }

    private void fight() {
        printFightersInfo(player);
        System.out.println("\nFighting...\n");
        TimeDelayer.delaySeconds();
        player.fightEnemy(enemy);
    }

    private void restartGame() {
        System.out.println("You lost the fight!");
        System.out.print("Press 'Enter' to restart ");
        Game.askForUserInput("");
        Game.initializeGame();
        Game.setState(new StartingGame());
    }
}
