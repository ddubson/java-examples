package com.ddubson.patterns.creational.abstractfactory.color;

/**
 * Author: ddubson
 */
public class Red implements Color {
    @Override
    public void fill() {
        System.out.print("RED");
    }
}
