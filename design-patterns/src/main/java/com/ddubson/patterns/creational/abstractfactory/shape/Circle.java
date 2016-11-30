package com.ddubson.patterns.creational.abstractfactory.shape;

/**
 * Author: ddubson
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.print("CIRCLE");
    }
}
