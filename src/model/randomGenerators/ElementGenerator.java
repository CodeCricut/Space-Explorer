package model.randomGenerators;

import model.elements.*;
import model.items.Item;
import ui.Game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class ElementGenerator {

    private static ArrayList<Element> elements = new ArrayList<>();

    public static ArrayList<Element> generateCommonElements(){
        if (elements.isEmpty()){
            addElements();
        }
        Random rand = new Random();

        ArrayList<Element> commonElements = new ArrayList<>();
        int numOfCommonElements = rand.nextInt(10) + 1;
        for (int i = 0; i < numOfCommonElements; i++){
            int elementInd = rand.nextInt(elements.size());
            if (! commonElements.contains(elements.get(elementInd))){
                commonElements.add(elements.get(elementInd));
            }
        }
        return commonElements;
    }

    public static Element generateOneCommonElement(){
        ArrayList<Element> elementsOnPlanet = Game.getPlanet().getElements();
        Random rand = new Random();
        int randElementInd = rand.nextInt(elementsOnPlanet.size());
        return elementsOnPlanet.get(randElementInd);
    }

    private static void addElements() {
        elements.add(new Carbon());
        elements.add(new Helium());
        elements.add(new Hydrogen());
        elements.add(new Iron());
        elements.add(new Magnesium());
        elements.add(new Neon());
        elements.add(new Nitrogen());
        elements.add(new Oxygen());
        elements.add(new Silicon());
        elements.add(new Sulfur());
    }
}
