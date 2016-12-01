package com.ddubson.patterns.creational.factory;

import com.ddubson.patterns.creational.common.Door;
import com.ddubson.patterns.creational.common.Room;
import com.ddubson.patterns.creational.factory.domain.DoorNeedingSpell;
import com.ddubson.patterns.creational.factory.domain.EnchantedRoom;
import com.ddubson.patterns.creational.factory.domain.Spell;

/**
 * Created by ddubs on 12/1/2016.
 */
public class EnchantedMazeGame extends MazeGame {
    protected Room makeRoom(int roomNumber) {
        return new EnchantedRoom(roomNumber, castSpell());
    }

    protected Door makeDoor(Room r1, Room r2) {
        return new DoorNeedingSpell(r1, r2);
    }

    public Spell castSpell() {
        return new Spell();
    }
}
