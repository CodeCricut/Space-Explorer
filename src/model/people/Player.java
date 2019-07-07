package model.people;

import exceptions.NotEnoughItemsException;
import exceptions.NotEnoughMoneyException;
import model.Inventory;
import model.items.Item;
import model.items.Weapon;

public class Player extends Person{
    private float maxHealth;
    private float currHealth;
    private Inventory inventory;
    private float money;
    private Weapon weapon;

    public Player(){
        maxHealth = 200;
        currHealth = maxHealth;
        inventory = new Inventory();
        money = 0;
        weapon = new Weapon(75);
    }

    //Getters and Setters

    public float getMaxHealth() {
        return maxHealth;
    }

    public float getCurrHealth() {
        return currHealth;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public float getMoney() {
        return money;
    }

    public void setCurrHealth(float currHealth) {
        this.currHealth = currHealth;
    }

    //Public Methods

    public void fightEnemy(Enemy enemy){
        double enemyDamage = enemy.getWeapon().getDamage();
        if (currHealth < enemyDamage){
            currHealth = 0;
        }
        else {
            currHealth -= enemyDamage;
        }
        enemy.processHit(weapon.getDamage());
    }

    public void buyItems(Item item, int numToBuy) throws NotEnoughMoneyException {
        if (item.getWorth()* numToBuy > money){
            throw new NotEnoughMoneyException();
        }
        money -= item.getWorth() * numToBuy;
        inventory.addItems(item, numToBuy);
        System.out.println(numToBuy + " " + item.getName() + "(s) added to inventory.");
    }

    public void sellItems(Item item, int numToSell) throws NotEnoughItemsException {
        int numOfItemInInventory = inventory.getNumOfItem(item);
        if (numOfItemInInventory < numToSell){
            throw new NotEnoughItemsException();
        }
        inventory.useNumOfItem(item, numToSell);
        depositFunds(item.getWorth() * numToSell);
    }

    public boolean isAlive(){
        return currHealth > 0;
    }


    //Money Modifiers
    public void depositFunds(float funds){
        money += funds;
    }

    public void withdrawalFunds(float amount) throws NotEnoughMoneyException {
        if (money < amount){
            throw new NotEnoughMoneyException();
        }
        money -= amount;
    }
}

