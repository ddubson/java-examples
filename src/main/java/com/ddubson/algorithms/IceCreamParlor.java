package com.ddubson.algorithms;

import java.util.Scanner;

/**
 * Created by ddubs on 10/19/2016.
 */
public class IceCreamParlor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int trips = sc.nextInt();
        for (int i = 0; i < trips; i++) {
            iceCreamTrip(sc);
        }
    }

    private static void iceCreamTrip(Scanner sc) {
        int moneyToSpend = sc.nextInt();
        int numFlavors = sc.nextInt();
        int[] costOfFlavor = new int[numFlavors+1];
        int[] saved = new int[numFlavors+1];

        for (int i = 1; i <= numFlavors; i++) {
             costOfFlavor[i] = sc.nextInt();
            saved[i] = moneyToSpend - costOfFlavor[i];
        }

        // $ m
        // x + y == m
        // m - x == c(y)
        // x + y == 4
        // c(1) = 4 - 1 = 3
        // c(2) = 4 - 4 = 0
        // c(3) = 4 - 5 = -1
        // c(4) = 4 - 3 = 1
        // c(5) = 4 - 2 = 2


        for (int i = 1; i < saved.length; i++) {
            for (int j = i + 1; j < saved.length; j++) {
                if (saved[i] + saved[j] == moneyToSpend) {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }
    }
}
