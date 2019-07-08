package model.randomGenerators;

import model.planetTypes.PlanetType;
import model.planetTypes.PlanetTypeEnum;

import java.util.List;
import java.util.Random;

public class PlanetTypeGenerator {

    private static final List<PlanetTypeEnum> VALUES = PlanetTypeEnum.getValues();
    private static final int SIZE = VALUES.size();

    private static final Random RANDOM = new Random();

    public static PlanetType generatePlanetType(){
        int pick = RANDOM.nextInt(PlanetTypeEnum.getValues().size());
        PlanetTypeEnum planetTypeEnum = VALUES.get(RANDOM.nextInt(SIZE));
        return PlanetTypeEnum.convertPlanetTypeEnumToPlanet(planetTypeEnum);
    }
}
