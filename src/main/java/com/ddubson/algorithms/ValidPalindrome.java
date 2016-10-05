package com.ddubson.algorithms;

/**
 * Author: ddubson
 */
public class ValidPalindrome {
    public static boolean isValidPalindrome(String str) {
        if(str.isEmpty()) return true;

        str = str.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
        int begin = 0;
        int end = str.length() - 1;

        while(begin < end) {
            if(str.charAt(begin) != str.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }

        return true;
    }
}
