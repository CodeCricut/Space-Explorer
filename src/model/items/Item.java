package model.items;

import org.reflections.Reflections;
import ui.Game;

import java.util.Set;

public class Item {
    protected String name;
    private float worth;

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
