package com.ddubson.algorithms;

import java.util.Scanner;

public class MaxSub {
    //WIP
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int sizeOfArray = s.nextInt();
        int numOfQueries = s.nextInt();

        long[] arr = new long[sizeOfArray];
        for(int i = 0; i < sizeOfArray; i++) {
            arr[i] = s.nextLong();
        }

        Long[][] sumMemo = new Long[sizeOfArray][sizeOfArray];
        Long[][] maxMemo = new Long[sizeOfArray][sizeOfArray];
        for(int i = 0; i < numOfQueries; i++) {
            int L = s.nextInt();
            int R = s.nextInt();
            System.out.println(F(maxMemo, sumMemo, arr, L-1, R-1));
        }
    }

    public static long F(Long[][] maxMemo, Long[][] sumMemo, long[] arr, int L, int R) {
        long allSum = 0;
        long rowSum = 0;
        for(int i = L; i <= R; i++) {
            if(sumMemo[i][R] != null) {
                allSum += sumMemo[i][R];
                continue;
            }

            rowSum = 0;
            for(int j = i; j <= R; j++) {
                if(maxMemo[i][j] == null) {
                    maxMemo[i][j] = max(arr, i, j);
                }

                rowSum += maxMemo[i][j];
            }

            allSum += rowSum;
            sumMemo[i][R] = rowSum;
        }

        return allSum;
    }

    public static long max(long[] arr, int start, int stop) {
        long max = arr[start];
        for(int i = start; i <= stop; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
        }

        return max;
    }
}



// F(A, 1, 4)
// sum=[max(1x1)+max(1x2)+max(1x3)+max(1x4)]
// sum=[2x2, 2x3, 2x4],
// sum=[3x3, 3x4],
// sum=[4x4]




// F(A, 1, 3)
// 1x1, 1x2, 1x3,      2x2, 2x3,      3x3
// F(A, 1, 2)
// 1x1, 1x2,           2x2

// F(A, 2, 4)
//                     2x2, 2x3, 2x4, 3x3, 3x4, 4x4
// F(A, 2, 3)
//                     2x2, 2x3,      3x3