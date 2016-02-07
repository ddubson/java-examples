package com.ddubson.euler.prob75;

import java.util.*;
import java.util.concurrent.*;

public class Problem implements Callable<Integer> {
    private int begin, end;
    private final static int ceiling = 1_500_000;

    public Problem(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new FutureTask<>(new Problem(2, 100_000)));
        executorService.submit(new FutureTask<>(new Problem(100_001, 200_000)));
        //List<FutureTask<Integer>> fts = Arrays.asList(new FutureTask<Integer>(new Problem(2, 100_000)), new FutureTask<Integer>(new Problem(100_001, 200_000)));
        while(!executorService.isTerminated()) {
            //executorService.
        }
        /*System.out.println("Number of L values: " + ft1.get());
        System.out.println(ft2.get());*/
        executorService.shutdown();
    }

    @Override
    public Integer call() throws Exception {
        Set<Integer> set= new HashSet<>();
        for (int i = begin; i < end; i++) {
            double isq = i * i;
            for (int j = end; j > i; j--) {
                double jsq = (j * j);
                double x = Math.sqrt(isq + jsq);

                if ((x - (int) x) == 0) {
                    int summed = i + j + (int) x;

                    if (summed >= 12 && summed <= ceiling) {
                        set.add(summed);
                    }
                }
            }
        }
        return set.size();
    }
}
