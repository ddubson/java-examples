package com.ddubson.patterns.creational.factory;

import org.junit.Test;

/**
 * Created by ddubs on 12/1/2016.
 */
public class MazeGameTest {
    @Test
    public void mazeGameTest() throws Exception {
        MazeGame mazeGame = new MazeGame();
        mazeGame.createMaze();
    }

    @Test
    public void bombedMazeGameTest() throws Exception {
        MazeGame mazeGame = new BombedMazeGame();
        mazeGame.createMaze();
    }
}