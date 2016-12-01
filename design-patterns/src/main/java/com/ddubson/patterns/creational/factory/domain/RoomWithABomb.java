package com.ddubson.patterns.creational.factory.domain;

import com.ddubson.patterns.creational.common.Room;

/**
 * Created by ddubs on 12/1/2016.
 */
public class RoomWithABomb extends Room {
    public RoomWithABomb(int roomNumber) {
        super(roomNumber);
        System.out.println("Room with a bomb.");
    }
}
