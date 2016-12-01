package com.ddubson.patterns.creational.factory.domain;

import com.ddubson.patterns.creational.common.Room;

/**
 * Created by ddubs on 12/1/2016.
 */
public class EnchantedRoom extends Room {
    public EnchantedRoom(int roomNumber, Spell spell) {
        super(roomNumber);
    }
}
