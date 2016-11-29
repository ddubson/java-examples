package com.ddubson.patterns.creational.builder;

import com.ddubson.patterns.creational.common.Door;
import com.ddubson.patterns.creational.common.Maze;
import com.ddubson.patterns.creational.common.Room;
import com.ddubson.patterns.creational.common.Wall;

import static com.ddubson.patterns.creational.common.Direction.*;

/**
 * Created by ddubs on 11/29/2016.
 */
public class MazeGame {
    /** Raw maze creation **/
    public Maze createMaze() {
        Maze maze = new Maze();
        Room r1 = new Room(1);
        Room r2 = new Room(2);
        Door theDoor = new Door(r1, r2);
        maze.addRoom(r1);
        maze.addRoom(r2);
        r1.setSide(NORTH, new Wall());
        r1.setSide(EAST, theDoor);
        r1.setSide(SOUTH, new Wall());
        r1.setSide(WEST, new Wall());

        r2.setSide(NORTH, new Wall());
        r2.setSide(EAST, new Wall());
        r2.setSide(SOUTH, new Wall());
        r2.setSide(WEST, theDoor);

        return maze;
    }

    /** Builder-driven maze creation **/
    public Maze createMaze(MazeBuilder builder) {
        builder.buildMaze();
        builder.buildRoom(1);
        builder.buildRoom(2);
        builder.buildDoor(1, 2);
        return builder.getMaze();
    }

    public static void main(String[] args) {
        MazeGame mazeGame = new MazeGame();
        Maze maze = mazeGame.createMaze();
        Maze maze2 = mazeGame.createMaze(new StandardMazeBuilder());
    }
}
