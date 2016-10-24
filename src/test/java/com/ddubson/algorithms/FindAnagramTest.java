package com.ddubson.algorithms;

import org.junit.Test;

import static com.ddubson.algorithms.FindAnagram.findAnagram;
import static com.ddubson.algorithms.FindAnagram.findAnagramAlt;
import static org.junit.Assert.assertEquals;

/**
 * Author: ddubson
 */
public class FindAnagramTest {
    @Test
    public void numOfDeletion() throws Exception {
        assertEquals(-1, findAnagram("", ""));
        assertEquals(-1, findAnagram("", "abc"));
        assertEquals(0, findAnagram("a", "a"));
        assertEquals(1, findAnagram("ab", "a"));
        assertEquals(4, findAnagramAlt("cde", "abc"));
        assertEquals(2, findAnagram("abc", "abcde"));
        assertEquals(30, findAnagramAlt("fcrxzwscanmligyxyvym",
                "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
    }


}