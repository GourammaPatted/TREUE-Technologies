package com.parkingsystem;

public class Main {
    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(10);

        parkingSystem.registerUser("user1");
        parkingSystem.registerUser("user2");

        User user1 = parkingSystem.getUser("user1");
        User user2 = parkingSystem.getUser("user2");

        ParkingSpot spot1 = parkingSystem.findAvailableSpot();
        if (spot1 != null) {
            parkingSystem.bookSpot(user1, spot1);
            System.out.println("User 1 booked spot " + spot1.getSpotId());
        } else {
            System.out.println("No available spots for User 1");
        }

        ParkingSpot spot2 = parkingSystem.findAvailableSpot();
        if (spot2 != null) {
            parkingSystem.bookSpot(user2, spot2);
            System.out.println("User 2 booked spot " + spot2.getSpotId());
        } else {
            System.out.println("No available spots for User 2");
        }

        if (spot1 != null) {
            parkingSystem.releaseSpot(user1, spot1);
            System.out.println("User 1 released spot " + spot1.getSpotId());
        }
    }
}
