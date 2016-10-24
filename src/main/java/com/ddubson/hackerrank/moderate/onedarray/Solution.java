package com.ddubson.hackerrank.moderate.onedarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by d.dubson on 2/19/2016.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named RansomNote. */
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(r.readLine());

        for (int i = 0; i < testCases; i++) {
            String line1 = r.readLine();
            int n = Integer.parseInt(line1.split(" ")[0]);
            int m = Integer.parseInt(line1.split(" ")[1]);

            String[] arrayStr = r.readLine().split(" ");
            int[] numArray = new int[n];
            int[] visitedArray = new int[n];

            Map<Integer, Path> lastPos = new HashMap<>();
            for (int j = 0; j < n; j++) {
                numArray[j] = Integer.parseInt(arrayStr[j]);
                lastPos.put(j, Path.NONE);
            }

            boolean haveWon = false;
            int interimPos = 0;
            while (true) {
                if (visitedArray[interimPos] >= 4) {
                    haveWon = false;
                    break;
                } else {
                    visitedArray[interimPos]++;
                }

                if (interimPos + m >= n || interimPos + 1 >= n) {
                    haveWon = true;
                    break;
                }

                if (interimPos + m != interimPos && numArray[interimPos + m] == 0) {
                    interimPos += m;
                    continue;
                }

                if (!lastPos.get(interimPos).equals(Path.PLUSONE) && numArray[interimPos + 1] == 0) {
                    lastPos.put(interimPos + 1, Path.MINUSONE);
                    interimPos++;
                    continue;
                }

                if (!lastPos.get(interimPos).equals(Path.MINUSONE) && interimPos - 1 >= 0 && numArray[interimPos - 1] == 0) {
                    lastPos.put(interimPos - 1, Path.PLUSONE);
                    interimPos--;
                    continue;
                }

                haveWon = false;
                break;
            }

            if (haveWon) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    enum Path {
        NONE,
        PLUSONE,
        MINUSONE
    }
}
