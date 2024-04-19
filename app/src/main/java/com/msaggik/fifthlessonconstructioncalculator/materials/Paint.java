package com.msaggik.fifthlessonconstructioncalculator.materials;

public class Paint {

    private double cost;
    private double consumption;

    public Paint(double cost, double consumption){
        this.cost = cost;
        this.consumption = consumption;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }
}
