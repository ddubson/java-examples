package com.ddubson.patterns.creational.builder;

import com.ddubson.patterns.creational.common.*;

/**
 * Created by ddubs on 11/29/2016.
 */
public class StandardMazeBuilder implements MazeBuilder {
    Maze currentMaze;

    public StandardMazeBuilder() {
        this.currentMaze = null;
    }

    private Direction commonWall(Room room1, Room room2) {
        return Direction.NORTH;
    }

    @Override
    public void buildMaze() {
        this.currentMaze = new Maze();
    }

    @Override
    public void buildRoom(int roomNumber) {
        if(currentMaze.getRoom(roomNumber) != null) return;

        Room room = new Room(roomNumber);
        this.currentMaze.addRoom(room);

        room.setSide(Direction.NORTH, new Wall());
        room.setSide(Direction.SOUTH, new Wall());
        room.setSide(Direction.EAST, new Wall());
        room.setSide(Direction.WEST, new Wall());
    }

    @Override
    public void buildDoor(int roomFrom, int roomTo) {
        Room room1 = currentMaze.getRoom(roomFrom);
        Room room2 = currentMaze.getRoom(roomTo);
        Door door = new Door(room1, room2);

        room1.setSide(commonWall(room1, room2), door);
        room2.setSide(commonWall(room2, room1), door);
    }

    @Override
    public Maze getMaze() {
        return this.currentMaze;
    }
}
