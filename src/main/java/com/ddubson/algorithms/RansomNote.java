package com.ddubson.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by ddubs on 10/19/2016.
 */
public class RansomNote {
    Map<String, Integer> magazineMap;
    String[] noteArr;

    public RansomNote(String magazine, String note) {
        this.noteArr = note.split(" ");
        this.magazineMap = new HashMap<>();
        String[] mWords = magazine.split(" ");
        for(String word : mWords) {
            if(this.magazineMap.containsKey(word)) {
                int v = this.magazineMap.get(word);
                this.magazineMap.put(word, v+1);
            } else {
                this.magazineMap.put(word, 1);
            }
        }
    }

    public boolean solve() {
        for(String word : noteArr) {
            if(this.magazineMap.containsKey(word) && this.magazineMap.get(word) > 0) {
                int count = this.magazineMap.get(word);
                this.magazineMap.put(word, count-1);
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        RansomNote s = new RansomNote(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");

    }
}
