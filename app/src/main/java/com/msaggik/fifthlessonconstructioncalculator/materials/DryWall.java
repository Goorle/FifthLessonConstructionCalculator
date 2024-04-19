package com.msaggik.fifthlessonconstructioncalculator.materials;

public class DryWall {

    private double heightDryWall;
    private double widthDryWall;
    private double cost;
    public DryWall(double heightDryWall, double widthDryWall, double cost){
        this.heightDryWall = heightDryWall;
        this.widthDryWall = widthDryWall;
        this.cost = cost;
    }

    public double getHeightDryWall() {
        return heightDryWall;
    }

    public void setHeightDryWall(double heightDryWall) {
        this.heightDryWall = heightDryWall;
    }

    public double getWidthDryWall() {
        return widthDryWall;
    }

    public void setWidthDryWall(double widthDryWall) {
        this.widthDryWall = widthDryWall;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
