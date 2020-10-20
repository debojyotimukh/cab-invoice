package com.capgemini.training.corejava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    private final Map<String, ArrayList<Ride>> userRides;

    public RideRepository() {
        this.userRides = new HashMap<>();
    }

    public void addRides(final String userId, final Ride[] rides) {
        final ArrayList<Ride> rideList = new ArrayList<>();
        Collections.addAll(rideList, rides);
        userRides.merge(userId, rideList, (vo, vn) -> {
            vo.addAll(vn);
            return vo;
        });
    }

    public Ride[] getRides(final String userId) {
        return this.userRides.get(userId).toArray(new Ride[0]);
    }

}
