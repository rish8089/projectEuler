package com.java.rishabh;

import java.util.ArrayList;
import java.util.List;

//it is referred to as pairs which cannot be written as sum of two abundant numbers

public class NonAbundantSums {

    int lim = 28123;

    public int getSumOfNonAbundantSums() {
        List<Integer> abundants = calculateAbundants();

        boolean visited[] = new boolean[lim];

        int cnt = 0;

        abundants.forEach(abundant -> {
            abundants.forEach(abundant1 -> {
                if (abundant + abundant1 < lim) {
                    visited[abundant + abundant1] = true;
                }
            });
        });

        for (int i = 1; i < lim; i++) {
            if (!visited[i]) {
                cnt=cnt+i;
            }
        }

        return cnt;


    }

    private List<Integer> calculateAbundants() {
        List<Integer> abundants = new ArrayList<>();
        for (int i = 2; i <= lim; i++) {
            int sum = 0;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    sum += j;
                    if (j != i / j) {
                        sum += i / j;
                    }
                }
            }

            if (sum > i) {
                abundants.add(i);
            }
        }

        return abundants;
    }

}
