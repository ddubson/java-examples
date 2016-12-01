package com.ddubson.patterns.creational.abstractfactory.shape;

/**
 * Author: ddubson
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.print("SQUARE");
    }
}
