package com.ddubson.hackerrank.moderate.countluck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiPredicate;

/**
 * Author: ddubson
 */
public class CountLuck {
    private static final char TREE = 'X', EMPTY = '.', START = 'M', END = '*', BEEN_HERE = 'Q';
    BufferedReader reader;
    XY start;
    int paths;
    boolean found = false;
    BiPredicate<char[][], XY> isOpenPath = (board, point) -> {
        if (point.X < 0 || point.Y < 0) return false;

        if (point.X >= board.length || point.Y >= board[0].length) {
            return false;
        }

        if (board[point.X][point.Y] == BEEN_HERE || board[point.X][point.Y] == START) {
            return false;
        }

        return board[point.X][point.Y] == EMPTY || board[point.X][point.Y] == END;
    };

    CountLuck() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String... args) throws IOException {
        new CountLuck().run();
    }

    void run() throws IOException {
        int numOfTestCases = readSingleInt();
        for (int i = 0; i < numOfTestCases; i++) {
            start = new XY();
            char[][] board = populateBoard(read2DArraySize());
            int K = readSingleInt();

            this.paths = 0;
            this.found = false;
            traverse(start, board);

            System.out.println("K: " + K + " | Forks: " + paths);
            //printArray(board);
            if (K == paths) {
                System.out.println("Impressed");
            } else {
                System.out.println("Oops!");
            }
        }
    }

    private void printArray(char[][] arr) {
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr[0].length; y++) {
                System.out.print(arr[x][y] + " ");
            }
            System.out.println();
        }
    }

    private void traverse(XY currentPos, char[][] board) {
        if (board[currentPos.X][currentPos.Y] == END) {
            found = true;
            return;
        }
        markAsTraversed(currentPos, board);
        XY left = new XY(currentPos.X - 1, currentPos.Y);
        XY right = new XY(currentPos.X + 1, currentPos.Y);
        XY top = new XY(currentPos.X, currentPos.Y - 1);
        XY bottom = new XY(currentPos.X, currentPos.Y + 1);
        boolean goLeft = isOpenPath.test(board, left);
        boolean goRight = isOpenPath.test(board, right);
        boolean goTop = isOpenPath.test(board, top);
        boolean goBottom = isOpenPath.test(board, bottom);

        boolean decisionPoint = false;
        int potentialPaths = (goLeft ? 1 : 0) + (goRight ? 1 : 0) + (goTop ? 1 : 0) + (goBottom ? 1 : 0);
        if (potentialPaths > 1) {
            this.paths++;
            decisionPoint = true;
        }

        if (goLeft && !found) traverse(left, board);
        if (goRight && !found) traverse(right, board);
        if (goTop && !found) traverse(top, board);
        if (goBottom && !found) traverse(bottom, board);

        if (decisionPoint && !found) {
            this.paths--;
        }
    }

    private void markAsTraversed(XY toMark, char[][] board) {
        board[toMark.X][toMark.Y] = BEEN_HERE;
    }

    private char[][] populateBoard(char[][] board) throws IOException {
        for (int j = 0; j < board.length; j++) {
            readRow(j, board);
        }
        return board;
    }

    private void readRow(int xIndex, char[][] board) throws IOException {
        char[] row = reader.readLine().toCharArray();
        for (int i = 0; i < row.length; i++) {
            if (row[i] == START) {
                start.X = xIndex;
                start.Y = i;
            }

            board[xIndex][i] = row[i];
        }
    }

    private int readSingleInt() throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private char[][] read2DArraySize() throws IOException {
        String[] dimensions = reader.readLine().split(" ");
        int N = Integer.parseInt(dimensions[0]);
        int M = Integer.parseInt(dimensions[1]);
        return new char[N][M];
    }

    class XY {
        public int X, Y;

        public XY() {
        }

        public XY(int x, int y) {
            X = x;
            Y = y;
        }
    }
}
