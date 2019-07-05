package model.planetTypes;

public abstract class PlanetType {
    protected String name;
    protected String description;

    protected double minTemp;
    protected double maxTemp;

    public double getMinTemp() {
        return minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
