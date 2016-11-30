package com.ddubson.patterns.creational.abstractfactory;

import com.ddubson.patterns.creational.abstractfactory.shape.Circle;
import com.ddubson.patterns.creational.abstractfactory.shape.Rectangle;
import com.ddubson.patterns.creational.abstractfactory.shape.Shape;
import com.ddubson.patterns.creational.abstractfactory.shape.Square;

public class ShapeFactory extends AbstractFactory<Shape> {
    @Override
    Shape get(String shapeType) {
        if(shapeType == null){
            throw new ShapeNotFound();
        }

        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();

        }else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();

        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        } else {
            throw new ShapeNotFound();
        }
    }

    public static class ShapeNotFound extends RuntimeException {
    }
}
