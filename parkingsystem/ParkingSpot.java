package com.parkingsystem;

import java.util.*;

class ParkingSpot {
    private int spotId;
    private boolean isAvailable;

    public ParkingSpot(int spotId) {
        this.spotId = spotId;
        this.isAvailable = true;
    }

    public int getSpotId() {
        return spotId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void book() {
        isAvailable = false;
    }

    public void release() {
        isAvailable = true;
    }
}

class User {
    private String username;
    private List<Integer> bookedSpots;

    public User(String username) {
        this.username = username;
        this.bookedSpots = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public List<Integer> getBookedSpots() {
        return bookedSpots;
    }

    public void bookSpot(int spotId) {
        bookedSpots.add(spotId);
    }

    public void releaseSpot(int spotId) {
        bookedSpots.remove(Integer.valueOf(spotId));
    }
}


