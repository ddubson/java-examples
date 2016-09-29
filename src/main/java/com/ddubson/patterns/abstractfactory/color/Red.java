package com.ddubson.patterns.abstractfactory.color;

/**
 * Author: ddubson
 */
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("RED");
    }
}
