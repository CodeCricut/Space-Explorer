package model.elements;

import model.items.Item;

public abstract class Element extends Item {
    protected int atomicNumber;

    public Element(String name, float worth, int atomicNumber) {
        super(name, worth);
        this.atomicNumber = atomicNumber;
    }
}
