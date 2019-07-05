package model.planetTypes;

public class Barren extends PlanetType {
    public Barren(){
        this.name = "Barren";
        this.description = "A landscape void of any movement. You may look as far as the eye can see, but will find little no flora or fauna";
        this.maxTemp = 200;
        this.minTemp = -40;
    }
}
