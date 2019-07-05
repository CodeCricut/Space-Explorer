package model.utilities;

import exceptions.ItemAdapterNotAccountedException;
import model.elements.*;
import model.items.*;

public class ItemAdapter {
    public static Item makeItem(String itemName){
        switch (itemName){
            case "Fuel Cartridge":
                return new FuelCartridge();
            case "Moon Rover":
                return new MoonRover();
            case "Quantum Fizz":
                return new QuantumFizz();
            case "Star Communicator":
                return new StarCommunicator();
            case "Carbon":
                return new Carbon();
            case "Helium":
                return new Helium();
            case "Hydrogen":
                return new Hydrogen();
            case "Iron":
                return new Iron();
            case "Magnesium":
                return new Magnesium();
            case "Neon":
                return new Neon();
            case "Nitrogen":
                return new Nitrogen();
            case "Oxygen":
                return new Oxygen();
            case "Silicon":
                return new Silicon();
            case "Sulfur":
                return new Sulfur();
            default:
                try {
                    throw new ItemAdapterNotAccountedException();
                } catch (ItemAdapterNotAccountedException e) {
                    e.printStackTrace();
                }
                return null;
        }
    }
}
