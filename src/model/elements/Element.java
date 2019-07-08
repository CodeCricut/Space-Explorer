package model.elements;

import model.items.Item;

public class Element extends Item {
    private int atomicNumber;

    Element(String name, float worth, int atomicNumber) {
        super(name, worth);
        this.atomicNumber = atomicNumber;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }
}
