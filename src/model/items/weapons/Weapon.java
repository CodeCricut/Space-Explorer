package model.items.weapons;

import model.items.Item;

import java.util.Random;

public class Weapon extends Item {
    private double damage;

    public Weapon(double damage){
        super("Weapon", 50);
        this.damage = damage;
    }
    public Weapon(){
        this(new Random().nextInt(100));
    }

    public double getDamage() {
        return damage;
    }
}
