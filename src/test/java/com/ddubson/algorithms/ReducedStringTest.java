package com.ddubson.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Author: ddubson
 */
public class ReducedStringTest {
    @Test
    public void emptyStringShouldReturnNeg1() throws Exception {
        assertEquals("", reduceString(""));
        assertEquals("", reduceString(null));
        assertEquals("", reduceString("aa"));
        assertEquals("", reduceString("baab"));
        assertEquals("abd", reduceString("aaabccddd"));
    }

    // baab --> bb --> empty

    private String reduceString(String s) {
        if(s==null) return "";

        StringBuilder str = new StringBuilder(s);
        boolean scan;
        while(true) {
            scan = false;
            for (int i = 0; i < str.length(); i++) {
                if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                    str.deleteCharAt(i);
                    str.deleteCharAt(i);
                    scan = true;
                }
            }

            if(!scan) break;
        }

        return str.toString();
    }
}
