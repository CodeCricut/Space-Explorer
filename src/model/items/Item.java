package model.items;

import ui.Game;

public abstract class Item implements Cloneable {
    protected String name;
    protected float worth;

    public Item(String name, float worth){
        this.name = name;
        this.worth = worth;
    }

    public String getName() {
        return name;
    }

    public float getWorth() {
        return worth;
    }

}
