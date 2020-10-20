package com.capgemini.training.corejava;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideRepository {
    private Map<String, List<Ride>> userRides;

    public RideRepository() {
        this.userRides = new HashMap<>();
    }

    public void addRides(String userId, Ride[] rides) {
        List<Ride> existingRides = this.userRides.get(userId);
        if (existingRides == null)
            this.userRides.put(userId, Arrays.asList(rides));
    }

    public Ride[] getRides(String userId) {
        return this.userRides.get(userId).toArray(new Ride[0]);
    }

}
