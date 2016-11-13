package com.ddubson.algorithms.arrays_lists;

/**
 * Created by ddubson on 10/20/2016.
 */
public class ReverseArray1 {
    // Reverse array without affecting non-alpha chars
    public static String reverseAlphabeticChars(String str) {
        int begin = 0;
        int end = str.length() - 1;

        StringBuilder stringBuilder = new StringBuilder(str);
        while(begin < end) {
            char a = str.charAt(begin);
            char b = str.charAt(end);

            if(!isAlphabetic(b)) {
                end--;
            } else if(!isAlphabetic(a)){
                begin++;
            } else {
                stringBuilder.setCharAt(begin, b);
                stringBuilder.setCharAt(end, a);
                begin++;
                end--;
            }
        }

        return stringBuilder.toString();
    }

    private static boolean isAlphabetic(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
