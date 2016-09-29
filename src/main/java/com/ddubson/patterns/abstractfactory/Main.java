package com.ddubson.patterns.abstractfactory;

import com.ddubson.patterns.abstractfactory.color.Color;
import com.ddubson.patterns.abstractfactory.shape.Shape;

/**
 * Author: ddubson
 */
public class Main {
    public static void main(String[] args) {

        //get shape factory
        AbstractFactory<Shape> shapeFactory = FactoryProducer.getFactory("SHAPE");

        //get an object of Shape Circle
        Shape shape1 = shapeFactory.get("CIRCLE");

        //call draw method of Shape Circle
        shape1.draw();

        //get an object of Shape Rectangle
        Shape shape2 = shapeFactory.get("RECTANGLE");

        //call draw method of Shape Rectangle
        shape2.draw();

        //get an object of Shape Square
        Shape shape3 = shapeFactory.get("SQUARE");

        //call draw method of Shape Square
        shape3.draw();

        //get color factory
        AbstractFactory<Color> colorFactory = FactoryProducer.getFactory("COLOR");

        //get an object of Color Red
        Color color1 = colorFactory.get("RED");

        //call fill method of Red
        color1.fill();

        //get an object of Color Green
        Color color2 = colorFactory.get("Green");

        //call fill method of Green
        color2.fill();

        //get an object of Color Blue
        Color color3 = colorFactory.get("BLUE");

        //call fill method of Color Blue
        color3.fill();
    }
}
