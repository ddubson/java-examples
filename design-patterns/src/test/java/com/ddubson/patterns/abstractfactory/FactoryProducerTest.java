package com.ddubson.patterns.abstractfactory;

import com.ddubson.patterns.abstractfactory.color.Color;
import com.ddubson.patterns.abstractfactory.shape.Shape;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Author: ddubson
 */
public class FactoryProducerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream saved;

    @Before
    public void setUp() throws Exception {
        saved = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(saved);
    }

    @Test
    public void factory_shouldProduceShapeFactory() throws Exception {
        Object shape = FactoryProducer.getFactory("SHAPE");
        Assert.assertTrue(shape instanceof ShapeFactory);
    }

    @Test
    public void factory_shouldProduceColorFactory() throws Exception {
        Object color = FactoryProducer.getFactory("COLOR");
        Assert.assertTrue(color instanceof ColorFactory);
    }

    @Test(expected = FactoryProducer.UnknownFactory.class)
    public void factory_shouldThrowErrorOnUnrecognizedFactory() throws Exception {
        FactoryProducer.getFactory("SCHPLURG");
    }

    @Test(expected = FactoryProducer.UnknownFactory.class)
    public void factory_shouldThrowErrorOnNullRequest() throws Exception {
        FactoryProducer.getFactory(null);
    }

    @Test
    public void factory_testFlow() throws Exception {
        //get shape factory
        ShapeFactory shapeFactory = (ShapeFactory) FactoryProducer.getFactory("SHAPE");
        Shape shape1 = shapeFactory.get("CIRCLE");
        shape1.draw();
        System.out.println();

        //get an object of Shape Rectangle
        Shape shape2 = shapeFactory.get("RECTANGLE");
        shape2.draw();
        System.out.println();

        //get an object of Shape Square
        Shape shape3 = shapeFactory.get("SQUARE");
        shape3.draw();
        System.out.println();

        //get color factory
        ColorFactory colorFactory = (ColorFactory) FactoryProducer.getFactory("COLOR");

        //get an object of Color Red
        Color color1 = colorFactory.get("RED");
        color1.fill();
        System.out.println();

        //get an object of Color Green
        Color color2 = colorFactory.get("GREEN");
        color2.fill();
        System.out.println();

        //get an object of Color Blue
        Color color3 = colorFactory.get("BLUE");
        color3.fill();

        Assert.assertEquals("CIRCLE" + System.lineSeparator() + "RECTANGLE" + System.lineSeparator() + "SQUARE" + System.lineSeparator() + "RED" +
                System.lineSeparator() + "GREEN" + System.lineSeparator() + "BLUE", outContent.toString());
    }
}