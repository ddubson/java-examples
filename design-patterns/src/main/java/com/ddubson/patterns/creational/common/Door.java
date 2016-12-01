package com.ddubson.patterns.creational.common;

/**
 * Created by ddubs on 11/29/2016.
 */
public class Door implements MapSite {
    private Room room1, room2;
    private boolean isOpen;

    @Override
    public void enter() {

    }

    public Room otherSideFrom(Room room) {
        return null;
    }

    public Door(Room room1, Room room2) {
        this.room1 = room1;
        this.room2 = room2;
        System.out.println("Created Door with room #" + room1.getRoomNumber() + " and room #" + room2.getRoomNumber());
    }
}
