package model.planetTypes;

public class Frozen extends PlanetType {
    public Frozen(){
        this.name = "Frozen";
        this.description = "Hell froze over. Only those with the thickest of coats can survive in such a cold place";
        this.maxTemp = -50;
        this.minTemp = -400;
    }
}
