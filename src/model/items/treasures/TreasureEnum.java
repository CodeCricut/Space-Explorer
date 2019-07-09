package model.items.treasures;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum TreasureEnum {
    MOON_ROVER("Moon Rover", 20),
    QUANTUM_FIZZ("Quantum Fizz", 30),
    STAR_COMMUNICATOR("Star Communicator", 50),
    FUEL_CARTRIDGE("Fuel Cartridge", 100);

    //Item Fields, Constructor, and Getters

    Treasure treasure;

    TreasureEnum(String name, float worth){
        treasure = new Treasure(name, worth);
    }

    public Treasure getTreasure() {
        return treasure;
    }

    //TreasureEnum Static Fields and Getters

    private static final List<TreasureEnum> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));

    public static List<TreasureEnum> getValues(){
        return VALUES;
    }
}
