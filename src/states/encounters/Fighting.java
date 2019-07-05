package states.encounters;

import model.utilities.Delimiter;
import model.utilities.TimeDelayer;
import model.people.Enemy;
import model.people.Player;
import states.StartingGame;
import states.State;
import ui.Game;

public class Fighting extends State {
    private Enemy enemy = new Enemy();


    @Override
    public void advance() {
        Delimiter.printCharDelimiter('X');
        Player player = Game.getPlayer();
        System.out.println("The enemy " + enemy.getName() + " approaches...");
        TimeDelayer.delaySeconds();
        while (player.isAlive() && enemy.isAlive()) {
            printFightersInfo(player);
            System.out.println("\nFighting...\n");
            TimeDelayer.delaySeconds();
            player.fightEnemy(enemy);
        }
        if (player.isAlive()){
            System.out.println("You won the fight! The enemy had some treasure on it.");
            Game.setState(new GettingTreasure());
            Delimiter.printCharDelimiter('X');
            return;
        }
        System.out.println("You lost the fight!");
        System.out.println("Restarting game...");
        TimeDelayer.delaySeconds();
        Game.initializeGame();
        Game.setState(new StartingGame());
    }

    private void printFightersInfo(Player player) {
        System.out.println("Enemy | Health = " + enemy.getCurrHealth() + " | Damage = " + enemy.getWeapon().getDamage());
        System.out.println(player.getName() + " | Health = " + player.getCurrHealth() + " | Damage = " + player.getWeapon().getDamage());
    }
}
