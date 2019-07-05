package model;

public class Ship {
    private int currFuel;
    private double fuelUsedOnTakeoff;

    public Ship(){
        fuelUsedOnTakeoff = 5;
        currFuel = 0;
    }

    public int getCurrFuel() {
        return currFuel;
    }

    public void depositFuel(int quantity){
        currFuel += quantity;
    }

    public boolean canTakeOff(){
        return currFuel >= fuelUsedOnTakeoff;
    }

    public void takeOff(){
        currFuel -= fuelUsedOnTakeoff;
    }


}
