package com.ddubson.patterns.creational.common;

/**
 * Created by ddubs on 11/29/2016.
 */
public class Room implements MapSite {
    private int roomNumber;
    private MapSite[] sides;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.sides = new MapSite[4];
        System.out.println("Created room #" + roomNumber);
    }

    public MapSite getSide(Direction direction) {
        return null;
    }

    public void setSide(Direction direction, MapSite mapSite) {

    }

    @Override
    public void enter() {

    }

    public int getRoomNumber() {
        return roomNumber;
    }
}
