package tests.people;

import model.people.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTests {
    private Enemy enemy;

    @BeforeEach
    void setup(){
        enemy = new Enemy();
    }
    @Test
    void testConstructor(){
        assertNotNull(enemy.getName());
        assertTrue(enemy.getMaxHealth() < 200);
        assertEquals(enemy.getMaxHealth(), enemy.getCurrHealth());
        assertNotNull(enemy.getWeapon());
        assertTrue(enemy.isAlive());
    }

    @Test
    void testProcessHitHealthLeft(){
        while(enemy.getMaxHealth() < 20){
            enemy = new Enemy();
        }

        assertTrue(enemy.getCurrHealth() >= 20);
        double healthBeforeHit = enemy.getCurrHealth();
        enemy.processHit(10);
        assertEquals(healthBeforeHit - 10, enemy.getCurrHealth());
    }

    @Test
    void testProcessHitNoHealthLeft(){
        assertTrue(enemy.getCurrHealth() > 0);
        enemy.processHit(enemy.getCurrHealth() + 10);
        assertEquals(0, enemy.getCurrHealth());
        assertFalse(enemy.isAlive());
    }
}
