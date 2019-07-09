package model.items.consumables;

import model.items.Item;

public abstract class Consumable extends Item {
    private String description;

    public Consumable(String name, String description, float worth){
        super(name, worth);
        this.description = description;
    }

    public abstract void consume();

    public String getDescription() {
        return description;
    }
}
