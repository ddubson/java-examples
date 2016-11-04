package com.ddubson.algorithms;

import org.junit.Test;

import static com.ddubson.algorithms.stacks_queues.BalancedBraces.isBalanced;
import static org.junit.Assert.*;

/**
 * Created by ddubs on 10/19/2016.
 */
public class BalancedBracesTest {
    @Test
    public void balancedBracesTest() throws Exception {
        assertEquals(true, isBalanced("{[()]}"));
        assertEquals(false, isBalanced("{[(])}"));
        assertEquals(true, isBalanced("{{[[(())]]}}"));

        assertEquals(false, isBalanced("}][}}(}][))]"));
        assertEquals(true, isBalanced("[](){()}"));
        assertEquals(true, isBalanced("()"));
        assertEquals(true, isBalanced("({}([][]))[]()"));
        assertEquals(false, isBalanced("{)[](}]}]}))}(())("));
    }


}