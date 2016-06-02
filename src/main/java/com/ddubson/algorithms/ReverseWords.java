package com.ddubson.algorithms;

import java.util.stream.Stream;

/**
 * Created by ddubson on 6/2/2016.
 */
public class ReverseWords {
    public static void main(String... args) {
        reverseWords();
    }

    private static void reverseWords() {
        String sentence = "This is a sentence to be reversed.";

        // Print original string
        System.out.println(sentence);

        // Set as character array
        char[] s = sentence.toCharArray();

        // Start at index 0
        int i = 0;
        for(int j = 0; j < s.length; j++) {
            // Find the next space
            if(s[j] == ' ') {
                // If space found, reverse the string from i to j-1
                reverse(s, i, j-1);

                // Increment i to the next word in the sentence
                i = j+1;
            }
        }

        // Reverse the last word in the sentence (loop only sees spaces, end of sentence does not have a space)
        reverse(s, i, s.length -1);

        // finally, reverse whole sentence
        reverse(s, 0, s.length -1);

        // Print reversed sentence
        Stream.of(s).forEach(System.out::print);
    }

    static void reverse(char[] s, int i, int j) {
        while(i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
