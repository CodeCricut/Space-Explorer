package model.people;

import model.randomGenerators.NameGenerator;
import model.items.weapons.Weapon;

import java.util.Random;

public class Enemy extends Person {
    private double maxHealth;
    private double currHealth;
    private Weapon weapon;

    public Enemy(){
        name = NameGenerator.generateName();
        Random random = new Random();
        maxHealth = random.nextInt(200);
        currHealth = maxHealth;
        weapon = new Weapon();
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public double getCurrHealth() {
        return currHealth;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void processHit(double hitDamage) {
        if (currHealth < hitDamage){
            currHealth = 0;
            return;
        }
        currHealth -= hitDamage;
    }

    public boolean isAlive(){
        return currHealth > 0;
    }
}
