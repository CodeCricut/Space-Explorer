package model.planetTypes;

public class PlanetType {
    private String type;
    private String description;

    private double maxTemp;
    private double minTemp;

    PlanetType(String type, String description, double minTemp, double maxTemp){
        this.type = type;
        this.description = description;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
