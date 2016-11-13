package com.ddubson.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Author: ddubson
 */
public class LRUCacheTest {
    @Test
    public void lruCache() throws Exception {
        LRUCache cache = new LRUCache(2);
        cache.set(2, 1);
        cache.set(1, 1);
        assertEquals(1, cache.get(2));
        cache.set(4, 1);
        assertEquals(-1, cache.get(1));
        assertEquals(1, cache.get(2));
    }

    @Test
    public void lruCache2() throws Exception {
        LRUCache cache = new LRUCache(2);
        cache.set(2, 1);
        cache.set(1, 1);
        cache.set(2, 3);
        cache.set(4, 1);
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(2));
    }


}