package com.ddubson.patterns.creational.abstractfactory;

import com.ddubson.patterns.creational.abstractfactory.color.Blue;
import com.ddubson.patterns.creational.abstractfactory.color.Color;
import com.ddubson.patterns.creational.abstractfactory.color.Green;
import com.ddubson.patterns.creational.abstractfactory.color.Red;

/**
 * Author: ddubson
 */
public class ColorFactory extends AbstractFactory<Color> {
    @Override
    public Color get(String color) {
        if (color == null) {
            return null;
        }

        if (color.equalsIgnoreCase("RED")) {
            return new Red();

        } else if (color.equalsIgnoreCase("GREEN")) {
            return new Green();

        } else if (color.equalsIgnoreCase("BLUE")) {
            return new Blue();
        }

        return null;
    }
}
