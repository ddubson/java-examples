package com.ddubson.patterns.abstractfactory;

import com.ddubson.patterns.abstractfactory.shape.Circle;
import com.ddubson.patterns.abstractfactory.shape.Rectangle;
import com.ddubson.patterns.abstractfactory.shape.Shape;
import com.ddubson.patterns.abstractfactory.shape.Square;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ShapeFactoryTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    ShapeFactory shapeFactory;
    PrintStream saved;

    @Before
    public void setUp() throws Exception {
        shapeFactory = new ShapeFactory();
        saved = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(saved);
    }

    @Test
    public void shapeFactory_shouldProduceSquare() throws Exception {
        Shape shape = shapeFactory.get("SQUARE");
        assertShapeClass(shape instanceof Square);
        shape.draw();
        assertShape("SQUARE");
    }

    @Test
    public void shapeFactory_shouldProduceCircle() throws Exception {
        Shape shape = shapeFactory.get("CIRCLE");
        assertShapeClass(shape instanceof Circle);
        shape.draw();
        assertShape("CIRCLE");
    }

    @Test
    public void shapeFactory_shouldProduceRectangle() throws Exception {
        Shape shape = shapeFactory.get("RECTANGLE");
        assertShapeClass(shape instanceof Rectangle);
        shape.draw();
        assertShape("RECTANGLE");
    }

    @Test(expected = ShapeFactory.ShapeNotFound.class)
    public void shapeFactory_shouldThrowExcIfShapeDoesNotExist() throws Exception {
        shapeFactory.get("RECCIRCID");
    }

    @Test(expected = ShapeFactory.ShapeNotFound.class)
    public void shapeFactory_shouldThrowExcIfShapeIsNull() throws Exception {
        shapeFactory.get(null);
    }

    private void assertShapeClass(boolean condition) {
        assertTrue(condition);
    }

    private void assertShape(String square) {
        assertEquals(square, outContent.toString());
    }
}