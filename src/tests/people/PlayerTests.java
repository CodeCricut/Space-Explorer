package tests.people;

import exceptions.NotEnoughMoneyException;
import model.items.Item;
import model.items.MoonRover;
import model.people.Enemy;
import model.people.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTests {

    private Player player;
    private Object exception;

    @BeforeEach
    void setup(){
        player = new Player();
    }

    @Test
    void testConstructor(){
        assertEquals(200, player.getMaxHealth());
        assertEquals(player.getCurrHealth(),  player.getMaxHealth());
        assertNotNull(player.getInventory());
        assertEquals(0, player.getMoney());
        assertNotNull(player.getWeapon());
    }

    @Test
    void testDepositFunds(){
        assertEquals( 0, player.getMoney());
        player.depositFunds(100);
        assertEquals(100, player.getMoney());
    }

    @Test
    void testWithdrawalFundsValid() throws NotEnoughMoneyException{
        assertEquals(0, player.getMoney());
        player.depositFunds(100);
        player.withdrawalFunds(10);
        assertEquals(90, player.getMoney());
    }

    @Test
    void testWithdrawalFundsInvalid() {
        assertEquals(0, player.getMoney());

        String test = null;
        assertThrows(NotEnoughMoneyException.class, () -> player.withdrawalFunds(10));

        assertEquals(0, player.getMoney());
    }

    @Test
    void testBuyItemsValidFunds() throws NotEnoughMoneyException {
        player.depositFunds(10000);
        assertEquals(10000, player.getMoney());

        Item moonRover = new MoonRover();
        player.buyItems(moonRover, 1);

        assertEquals(1, player.getInventory().getNumOfItem(moonRover));
        assertEquals(9900, player.getMoney());

        player.buyItems(moonRover, 2);

        assertEquals(3, player.getInventory().getNumOfItem(moonRover));
        assertEquals(9700, player.getMoney());
    }

    @Test
    void testBuyItemsInvalidFunds() throws NotEnoughMoneyException {
        assertEquals(0, player.getMoney());

        Item moonRover = new MoonRover();

        player.buyItems(moonRover, 0);

        assertThrows(NotEnoughMoneyException.class, () -> player.buyItems(moonRover, 1));

        assertThrows(NotEnoughMoneyException.class, () -> player.buyItems(moonRover, 2));
    }

    @Test
    void testFightEnemyHealthRemaining(){
        assertEquals(200, player.getCurrHealth());

        Enemy enemy = new Enemy();
        double enemyDamage = enemy.getWeapon().getDamage();
        player.fightEnemy(enemy);

        assertEquals(200 - enemyDamage, player.getCurrHealth());
        assertTrue(player.isAlive());
    }

    @Test
    void testFightEnemyNoHealthRemaining(){
        assertEquals(200, player.getCurrHealth());
        Enemy enemy = new Enemy();

        while(player.getCurrHealth() > 0){
            player.fightEnemy(enemy);
        }

        assertEquals(0, player.getCurrHealth());
        assertFalse(player.isAlive());
    }

}
