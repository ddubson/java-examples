package com.ddubson.algorithms.arrays_lists;

import org.junit.Test;

import static com.ddubson.algorithms.arrays_lists.ReverseArray1.reverseAlphabeticChars;
import static org.junit.Assert.*;

/**
 * Created by ddubson on 10/20/2016.
 */
public class ReverseArray1Test {
    @Test
    public void reverseArray1Test() throws Exception {
        assertEquals("", reverseAlphabeticChars(""));
        assertEquals("$", reverseAlphabeticChars("$"));
        assertEquals("$a", reverseAlphabeticChars("$a"));
        assertEquals("b%$a", reverseAlphabeticChars("a%$b"));
        assertEquals("c,b$a", reverseAlphabeticChars("a,b$c"));
        assertEquals("ed,c,bA!$", reverseAlphabeticChars("Ab,c,de!$"));
        assertEquals("i!!!h.g.f,e'd,cba", reverseAlphabeticChars("a!!!b.c.d,e'f,ghi"));
    }
}