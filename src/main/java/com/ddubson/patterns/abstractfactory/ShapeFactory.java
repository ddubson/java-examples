package com.ddubson.patterns.abstractfactory;

import com.ddubson.patterns.abstractfactory.shape.Circle;
import com.ddubson.patterns.abstractfactory.shape.Rectangle;
import com.ddubson.patterns.abstractfactory.shape.Shape;
import com.ddubson.patterns.abstractfactory.shape.Square;

/**
 * Author: ddubson
 */
public class ShapeFactory extends AbstractFactory<Shape> {
    @Override
    Shape get(String shapeType) {
        if(shapeType == null){
            return null;
        }

        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();

        }else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();

        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }

        return null;
    }
}
