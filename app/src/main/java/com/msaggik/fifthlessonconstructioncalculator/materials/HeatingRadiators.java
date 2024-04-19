package com.msaggik.fifthlessonconstructioncalculator.materials;

public class HeatingRadiators {

    private int powerRadiators;
    private double costRadiators;

    public HeatingRadiators(int powerRadiators, double costRadiators){
        this.powerRadiators = powerRadiators;
        this.costRadiators = costRadiators;
    }

    public int getPowerRadiators() {
        return powerRadiators;
    }

    public void setPowerRadiators(int powerRadiators) {
        this.powerRadiators = powerRadiators;
    }

    public double getCostRadiators() {
        return costRadiators;
    }

    public void setCostRadiators(double costRadiators) {
        this.costRadiators = costRadiators;
    }
}
