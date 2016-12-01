package com.ddubson.patterns.creational.factory.domain;

import com.ddubson.patterns.creational.common.Door;
import com.ddubson.patterns.creational.common.Maze;
import com.ddubson.patterns.creational.common.Room;
import com.ddubson.patterns.creational.common.Wall;

import static com.ddubson.patterns.creational.common.Direction.*;

/**
 * Created by ddubs on 12/1/2016.
 */
public class MazeGame {
    public Maze createMaze() {
        Maze maze = makeMaze();
        Room r1 = makeRoom(1);
        Room r2 = makeRoom(2);
        Door door = makeDoor(r1, r2);

        maze.addRoom(r1);
        maze.addRoom(r2);

        r1.setSide(NORTH, makeWall());
        r1.setSide(SOUTH, door);
        r1.setSide(EAST, makeWall());
        r1.setSide(WEST, makeWall());

        r2.setSide(NORTH, makeWall());
        r2.setSide(SOUTH, makeWall());
        r2.setSide(EAST, makeWall());
        r2.setSide(WEST, door);

        return maze;
    }

    protected Maze makeMaze() {
        return new Maze();
    }

    protected Room makeRoom(int roomNumber) {
        return new Room(roomNumber);
    }

    protected Wall makeWall() {
        return new Wall();
    }

    protected Door makeDoor(Room r1, Room r2) {
        return new Door(r1, r2);
    }
}
