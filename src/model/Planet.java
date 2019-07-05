package model;

import model.elements.Element;
import model.planetTypes.PlanetType;
import model.randomGenerators.ElementGenerator;
import model.randomGenerators.NameGenerator;
import model.randomGenerators.PlanetTypeGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Planet {
    private String name;
    private PlanetType type;

    private double currTemp;

    private ArrayList<Element> elements;

    public Planet(){
        name = NameGenerator.generateName();
        type = PlanetTypeGenerator.generatePlanetType();
        Random random = new Random();
        currTemp = ThreadLocalRandom.current().nextDouble(type.getMinTemp(), type.getMaxTemp());
        elements = ElementGenerator.generateCommonElements();
    }

    public String getName() {
        return name;
    }

    public PlanetType getType() {
        return type;
    }

    public double getCurrTemp() {
        return currTemp;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }
}