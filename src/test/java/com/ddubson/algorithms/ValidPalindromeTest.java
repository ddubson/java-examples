package com.ddubson.algorithms;

import org.junit.Test;

import static com.ddubson.algorithms.ValidPalindrome.isValidPalindrome;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Author: ddubson
 */
public class ValidPalindromeTest {
    @Test
    public void validPalindrome() throws Exception {
        assertTrue(isValidPalindrome("Red rum, sir, is murder"));
        assertTrue(isValidPalindrome("aa"));
        assertTrue(isValidPalindrome("aba"));
        assertTrue(isValidPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void nonValidPalindrome() throws Exception {
        assertFalse(isValidPalindrome("Something something"));
        assertFalse(isValidPalindrome("ab"));
    }
}
