package ui;

import model.Planet;
import model.Ship;
import model.elements.*;
import model.items.*;
import model.people.Player;
import model.utilities.Delimiter;
import states.Debugging;
import states.StartingGame;
import states.State;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private static Player player;
    private static Ship ship;
    private static State state;
    private static Scanner scanner = new Scanner(System.in);
    private static Planet planet;


    public static void initializeGame(){
        player = new Player();
        ship = new Ship();
        state = new StartingGame();
        planet = new Planet();
    }


    static void progressGame(){
        while(true){
            Delimiter.printEmtpyLines(3);
            state.advance();
        }
    }


    public static Player getPlayer() {
        return player;
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
