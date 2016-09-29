package com.ddubson.patterns.abstractfactory;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Author: ddubson
 */
public class FactoryProducerTest {
    @Test
    public void factory_shouldProduceShapeFactory() throws Exception {
        Object shape = FactoryProducer.getFactory("SHAPE");
        assertTrue(shape instanceof ShapeFactory);
    }

    @Test
    public void factory_shouldProduceColorFactory() throws Exception {
        Object color = FactoryProducer.getFactory("COLOR");
        assertTrue(color instanceof ColorFactory);
    }

    @Test(expected = FactoryProducer.UnknownFactory.class)
    public void factory_shouldThrowErrorOnUnrecognizedFactory() throws Exception {
        FactoryProducer.getFactory("SCHPLURG");
    }

    @Test(expected = FactoryProducer.UnknownFactory.class)
    public void factory_shouldThrowErrorOnNullRequest() throws Exception {
        FactoryProducer.getFactory(null);
    }
}