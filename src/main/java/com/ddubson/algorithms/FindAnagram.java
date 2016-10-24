package com.ddubson.algorithms;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: ddubson
 */
public class FindAnagram {
    public static int findAnagram(String a, String b) {
        if(a == null || a.isEmpty() || b == null || b.isEmpty()) {
            return -1;
        }

        Map<Character, Integer> mapA = new ConcurrentHashMap<>();
        Map<Character, Integer> mapB = new ConcurrentHashMap<>();

        // Map strings
        populateMap(a, mapA);
        populateMap(b, mapB);

        // Find differences
        for(Map.Entry entry : mapA.entrySet()) {
            char c = (char) entry.getKey();
            int val = (int) entry.getValue();
            if(mapB.containsKey(c)) {
                int decTimes = val < mapB.get(c) ? val : mapB.get(c);
                decrementOrRemove(mapA, c, decTimes);
                decrementOrRemove(mapB, c, decTimes);
            }
        }

        // Tally up the differences
        int total = 0;
        if(!mapA.isEmpty()) {
            total += mapA.values().stream().reduce(0, Integer::sum);
        }

        if(!mapB.isEmpty()) {
            total += mapB.values().stream().reduce(0, Integer::sum);
        }

        return total;
    }

    private static void decrementOrRemove(Map<Character, Integer> map, char c, int times) {
        while(times > 0) {
            int count = map.get(c);
            if (count > 1) {
                map.put(c, count - 1);
            } else {
                map.remove(c);
            }
            times--;
        }
    }

    public static int findAnagramAlt(String first, String second) {
        int[] map = new int[26];

        for(int i = 0; i < first.length(); i++){
            map[first.charAt(i) - 'a']++;
        }
        for(int i = 0; i < second.length(); i++){
            map[second.charAt(i) - 'a']--;
        }

        return Arrays.stream(map).filter(k -> k != 0).reduce(0, (k, v) -> k + Math.abs(v));
    }

    private static void populateMap(String str, Map<Character, Integer> map) {
        for(char c : str.toCharArray()) {
            int count = 0;

            if(map.containsKey(c)) {
                count = map.get(c);
            }

            map.put(c, count+1);
        }
    }
}
