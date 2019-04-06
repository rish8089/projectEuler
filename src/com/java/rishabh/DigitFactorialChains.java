package com.java.rishabh;

public class DigitFactorialChains {

    int lim = 1000000;
    int fact[];

    DigitFactorialChains() {
        fact = new int[10];
    }

    int getNumbersWithChainLengthSix() {
        int cnt = 0;
        computeFactorials();
        for (int i = 3; i < lim; i++) {
            int chainLength = 1 + recurse(i);
            if (chainLength == 60) {
                cnt++;
            }
        }
        return cnt;
    }

    private int recurse(int i) {
        int sum = getSumOfFactorialsInNum(i);

        if(i==sum)
            return 0;
        else if(sum==169 || sum==363601 || sum==1454)
            return 3;
        else if(sum==871 || sum==872 || sum==45361 || sum==45362)
            return 2;
        else
            return 1+recurse(sum);
    }

    private int getSumOfFactorialsInNum(int num) {
        int d, s = 0;
        while (num > 0) {
            d = num % 10;
            num = num / 10;
            s = s + fact[d];
        }
        return s;
    }

    private void computeFactorials() {
        fact[0] = 1;
        for (int i = 1; i <= 9; i++) {
            fact[i] = fact[i - 1] * i;
        }
    }

}
