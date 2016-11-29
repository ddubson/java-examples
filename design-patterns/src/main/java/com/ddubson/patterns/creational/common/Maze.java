package com.ddubson.patterns.creational.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by ddubs on 11/29/2016.
 */
public class Maze {
    private List<Room> rooms;

    public Maze() {
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public Room getRoom(int roomNo) {
        return rooms.stream().filter(room -> room.getRoomNumber()==roomNo).findFirst().orElse(null);
    }
}
