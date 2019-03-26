package com.java.rishabh;

import java.util.ArrayList;
import java.util.List;

public class SubstringDivisibility {

    int divisors[] = new int[7];

    SubstringDivisibility() {
        divisors[0] = 2;
        divisors[1] = 3;
        divisors[2] = 5;
        divisors[3] = 7;
        divisors[4] = 11;
        divisors[5] = 13;
        divisors[6] = 17;
    }

    public long getSumOfPandigitalNumbers() {

        boolean vis[] = new boolean[10];
        long sum = 0;

        for (int i = 0; i <= 9; i++) {
            if (!vis[i]) {
                vis[i] = true;
                sum = sum + constructPandigitalNumbers(vis, i);
                vis[i] = false;
            }

        }
        return sum;
    }

    private long constructPandigitalNumbers(boolean vis[], long combination) {
        boolean flag = true;
        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            if (!vis[i]) {
                vis[i] = true;
                flag = false;
                sum = sum + constructPandigitalNumbers(vis, combination * 10 + i);
                vis[i] = false;
            }
        }

        if (flag && checkIfPandigitalNumberHasSubstringDivisibilityProperty(combination)) {
            System.out.println("combination = " + combination);
            return combination;
        }
        return sum;
    }


    private boolean checkIfPandigitalNumberHasSubstringDivisibilityProperty(long num) {
        List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add((int) (num % 10));
            num = num / 10;
        }

        boolean flag = true;
        for (int i = 0; i < digits.size() - 3; i++) {
            int dividend = (digits.get(i + 2) * 10 + digits.get(i + 1)) * 10 + digits.get(i);

            if (dividend % divisors[divisors.length - i - 1] != 0) {
                flag = false;
                break;
            }
        }

        return flag;
    }

}


