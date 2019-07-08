package model;

import java.util.Random;

public class Weapon {
    private double damage;

    public Weapon(double damage){
        this.damage = damage;
    }
    public Weapon(){
        this(new Random().nextInt(100));
    }

    public double getDamage() {
        return damage;
    }
}
