package com.ddubson.patterns.abstractfactory.shape;

/**
 * Author: ddubson
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("RECTANGLE");
    }
}
