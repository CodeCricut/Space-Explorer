package ui;

import model.Planet;
import model.Ship;
import model.elements.*;
import model.items.*;
import model.people.Player;
import model.utilities.Delimiter;
import states.ArrivingOnPlanet;
import states.Debugging;
import states.StartingGame;
import states.State;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Game {
    private static Player player;
    private static Ship ship;
    private static State state;
    private static Scanner scanner = new Scanner(System.in);
    private static Planet planet;
    private static ArrayList<Item> universeItems = new ArrayList<>();
    private static ArrayList<Element> universeElements = new ArrayList<>();


    public static void initializeGame(){
        initializeUniverseItems();
        initializeUniverseElements();

        player = new Player();
        ship = new Ship();
        state = new StartingGame();
        planet = new Planet();
    }

    private static void initializeUniverseElements() {
        universeElements.add(new Carbon());
        universeElements.add(new Helium());
        universeElements.add(new Hydrogen());
        universeElements.add(new Iron());
        universeElements.add(new Magnesium());
        universeElements.add(new Neon());
        universeElements.add(new Nitrogen());
        universeElements.add(new Oxygen());
        universeElements.add(new Silicon());
        universeElements.add(new Sulfur());
    }


    /*
    It is not ideal to manually add each item to a list, but is a difficult
    problem to fix in Java.
     */
    private static void initializeUniverseItems() {
        universeItems.add(new FuelCartridge());
        universeItems.add(new MoonRover());
        universeItems.add(new QuantumFizz());
        universeItems.add(new StarCommunicator());
        universeItems.add(new Weapon());
    }

    static void progressGame(){
        while(true){
            Delimiter.printEmtpyLines(3);
            state.advance();
        }
    }

    public static ArrayList<Item> getUniverseItems() {
        return universeItems;
    }

    public static Player getPlayer() {
        return player;
    }

    public static ArrayList<Element> getUniverseElements() {
        return universeElements;
    }

    public static void setPlayer(Player player) {
        Game.player = player;
    }

    public static Ship getShip() {
        return ship;
    }

    public static void setState(State state) {
        Game.state = state;
    }

    public static String askForUserInput(String pretext){
        System.out.print(pretext);
        return scanner.nextLine();
    }

    public static Planet getPlanet() {
        return planet;
    }

    public static void setPlanet(Planet planet) {
        Game.planet = planet;
    }

    public static State getState() {
        return state;
    }
}
