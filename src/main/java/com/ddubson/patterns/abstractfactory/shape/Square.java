package com.ddubson.patterns.abstractfactory.shape;

/**
 * Author: ddubson
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("SQUARE");
    }
}
