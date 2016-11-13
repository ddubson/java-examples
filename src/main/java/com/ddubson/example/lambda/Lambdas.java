package com.ddubson.example.lambda;

import java.util.stream.Stream;

/**
 * Author: ddubson
 */
public class Lambdas {
    public static void main(String[] args) {
        // Consumer = functions that take in one parameter and return void (nothing)
        // e.g. forEach takes in a generic Consumer
        Stream.of(2,4,5,3).forEach(integer -> System.out.print(integer+" "));

        // DoubleConsumer, IntConsumer, etc. are specific versions of a generic Consumer<T>

        // Supplier = functions that take in no parameters and produce a value of type T

    }
}
