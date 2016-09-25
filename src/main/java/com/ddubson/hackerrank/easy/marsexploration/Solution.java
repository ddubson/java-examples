package com.ddubson.hackerrank.easy.marsexploration;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by ddubson on 9/21/2016.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int index = 0;
        int sum = 0;
        while (!s.isEmpty()) {
            String SOS = s.substring(index, index + 3);
            if(SOS.charAt(0) != 'S') sum++;
            if(SOS.charAt(1) != 'O') sum++;
            if(SOS.charAt(2) != 'S') sum++;
            if(s.length() <= index+3) {
                break;
            }
            index += 3;
        }

        System.out.println(sum);
    }
}
