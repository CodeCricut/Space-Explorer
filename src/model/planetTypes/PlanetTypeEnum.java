package model.planetTypes;

import model.items.ItemEnum;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum PlanetTypeEnum {
    BARREN("Barren",
            "A landscape void of any movement. You may look as far as the eye can see, but will find little no flora or fauna",
            -40, 200),
    FROZEN("Frozen",
            "Hell froze over. Only those with the thickest of coats can survive in such a cold place",
            -400, -50),
    LUSH("Lush",
            "A beautiful planet with abundant flora and fauna.",
            50, 130),
    SCORCHED("Scorched",
            "A hot wasteland. Only those equipped could survive in such Hell.",
            200, 400);

    //PlanetType Fields, Constructor, and Getters

    private String type;
    private String description;
    private double minTemp, maxTemp;

    PlanetTypeEnum(String type, String description, double minTemp, double maxTemp){
        this.type = type;
        this.description = description;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    //PlanetTypeEnum Static Fields and Getters

    private static final List<PlanetTypeEnum> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));

    public static List<PlanetTypeEnum> getValues(){
        return VALUES;
    }

    //Converters

    public static PlanetType convertPlanetTypeEnumToPlanet(PlanetTypeEnum planetTypeEnum){
        String type = planetTypeEnum.getType();
        String description = planetTypeEnum.getDescription();
        double minTemp = planetTypeEnum.getMinTemp();
        double maxTemp = planetTypeEnum.getMaxTemp();
        return new PlanetType(type, description, minTemp, maxTemp);
    }
}
