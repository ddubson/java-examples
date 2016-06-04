package com.ddubson.algorithms;

/**
 * Author: ddubson
 */
public class StringRotation {
    public static void main(String... args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.print("Is '"+s1+"' a rotation of '"+s2+"'? ");
        System.out.print(isRotation(s1,s2));
    }

    public static boolean isRotation(String s1, String s2) {
        // Store original String
        String orig = s1;

        // Do initial rotation
        s1 = rotateOnce(s1);

        // Check if s1 hasn't been rotated back to its original state
        while(!s1.equals(orig)) {
            // Compare rotated s1 to s2
            if(s1.equals(s2)) {
                return true;
            }

            // Rotate again
            s1 = rotateOnce(s1);
        }


        return false;
    }

    public static String rotateOnce(String input) {
        char tail = input.charAt(input.length() - 1);

        char[] str = input.toCharArray();
        for(int i = input.length() - 1; i > 0; i--) {
            str[i] = str[i-1];
        }
        str[0] = tail;

        return new String(str);
    }

}
