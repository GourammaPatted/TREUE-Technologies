package com.parkingsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ParkingSystem {
    private List<ParkingSpot> parkingSpots;
    private Map<String, User> users;

    public ParkingSystem(int numSpots) {
        parkingSpots = new ArrayList<>();
        for (int i = 1; i <= numSpots; i++) {
            parkingSpots.add(new ParkingSpot(i));
        }
        users = new HashMap<>();
    }

    public ParkingSpot findAvailableSpot() {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable()) {
                return spot;
            }
        }
        return null;
    }

    public void bookSpot(User user, ParkingSpot spot) {
        spot.book();
        user.bookSpot(spot.getSpotId());
    }

    public void releaseSpot(User user, ParkingSpot spot) {
        spot.release();
        user.releaseSpot(spot.getSpotId());
    }

    public void registerUser(String username) {
        users.put(username, new User(username));
    }

    public User getUser(String username) {
        return users.get(username);
    }
}
