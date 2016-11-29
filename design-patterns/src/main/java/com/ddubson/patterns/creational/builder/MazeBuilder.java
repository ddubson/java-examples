package com.ddubson.patterns.creational.builder;

import com.ddubson.patterns.creational.common.Maze;

/**
 * Created by ddubs on 11/29/2016.
 */
public interface MazeBuilder {
    void buildMaze();

    void buildRoom(int room);

    void buildDoor(int roomFrom, int roomTo);

    Maze getMaze();
}
