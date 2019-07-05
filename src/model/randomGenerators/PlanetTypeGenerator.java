package model.randomGenerators;

import model.planetTypes.PlanetType;
import model.planetTypes.Barren;
import model.planetTypes.Frozen;
import model.planetTypes.Lush;
import model.planetTypes.Scorched;

import java.util.Random;

public class PlanetTypeGenerator {
    private enum Type {
        BARREN,
        FROZEN,
        LUSH,
        SCORCHED
    }

    public static PlanetType generatePlanetType(){
        Random random = new Random();
        int pick = random.nextInt(Type.values().length);
        Type planetType = Type.values()[pick];

        switch (planetType){
            case BARREN:
                return new Barren();
            case FROZEN:
                return new Frozen();
            case LUSH:
                return new Lush();
            case SCORCHED:
                return new Scorched();
            default:
                return new Barren();
        }
    }
}
