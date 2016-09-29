package com.ddubson.patterns.abstractfactory;

/**
 * Author: ddubson
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) throws UnknownFactory {
        if (choice == null) {
            throw new UnknownFactory();
        }

        if (choice.equalsIgnoreCase("SHAPE")) {
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("COLOR")) {
            return new ColorFactory();
        } else {
            throw new UnknownFactory();
        }
    }

    public static class UnknownFactory extends RuntimeException {
    }
}
