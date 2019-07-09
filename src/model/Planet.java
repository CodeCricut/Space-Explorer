package model;

import model.items.elements.Element;
import model.planetTypes.PlanetType;
import model.factories.ElementFactory;
import model.factories.NameFactory;
import model.factories.PlanetTypeFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class Planet {
    private String name;
    private PlanetType type;
    private double currTemp;
    private HashSet<Element> elements;

    public Planet(){
        name = NameFactory.generateName();
        type = PlanetTypeFactory.generatePlanetType();
        currTemp = ThreadLocalRandom.current().nextDouble(type.getMinTemp(), type.getMaxTemp());
        elements = ElementFactory.generateMultipleElements();
    }

    //Getters

    public String getName() {
        return name;
    }

    public PlanetType getType() {
        return type;
    }

    public double getCurrTemp() {
        return currTemp;
    }

    public HashSet<Element> getElements() {
        return elements;
    }
}
