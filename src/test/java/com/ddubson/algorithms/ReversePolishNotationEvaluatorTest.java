package com.ddubson.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ddubson on 9/29/2016.
 */
public class ReversePolishNotationEvaluatorTest {
    @Test
    public void evaluator_shouldReturnExpectedValue() throws Exception {
        ReversePolishNotationEvaluator evaluator = new ReversePolishNotationEvaluator();
        assertTrue(evaluator.evaluate("2 3 + 1 *")==5);
        assertTrue(evaluator.evaluate("3 4 + 3 +")==10);
        assertTrue(evaluator.evaluate("14 2 * 8 +")==36);
        assertTrue(evaluator.evaluate("10 5 / 2 +")==4);
        assertTrue(evaluator.evaluate("10 5 / 2 -")==0);
    }
}