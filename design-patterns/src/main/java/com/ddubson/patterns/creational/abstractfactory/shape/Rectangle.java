package com.ddubson.patterns.creational.abstractfactory.shape;

/**
 * Author: ddubson
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.print("RECTANGLE");
    }
}
