package com.capgemini.training.corejava;

public class Ride {

    public double distance;
    public int time;
    public CabRides CabRides;

    public Ride(final CabRides cabRides, final double distance, final int time) {
        this.distance = distance;
        this.time = time;
        CabRides = cabRides;
    }
 

}
