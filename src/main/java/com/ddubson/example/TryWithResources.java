package com.ddubson.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Author: ddubson
 */
public class TryWithResources {
    public static void main(String[] args) {
        Path path = Paths.get("src", "main", "resources");
        try (BufferedReader br = Files.newBufferedReader(path.resolve("input.txt"))) {
            while (br.ready()) {
                System.out.println(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
