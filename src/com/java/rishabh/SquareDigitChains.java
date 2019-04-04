package com.java.rishabh;


//99 can go to 162
//999 can go till 243, so we are going bacl
public class SquareDigitChains {

    int lim = 10000000;
    int memorise[];

    SquareDigitChains() {
        memorise = new int[lim];
    }

    public int getNumbersBelowOneMillionEndingWith89() {
        memorise[89] = 1;
        int cnt = 0;
        for (int i = 2; i < lim; i++) {

            cnt += (recurse(i) == 1 ? 1 : 0);
        }
        return cnt;
    }

    private int recurse(int i) {

        if (i == 1) {
            return -1; //not possible to reach 89 if not reached yet.
        } else if (memorise[i] == 1) {
            return 1;//can be reached to 89
        } else {
            int sumOfSquareOfDigits = getSumOfSquareOfDigits(i);
            int ret = recurse(sumOfSquareOfDigits);
            if (ret == 1) {
                memorise[i] = 1;
            } else {
                memorise[i] = -1;
            }
            return memorise[i];
        }
    }

    private int getSumOfSquareOfDigits(int num) {
        int sum = 0, d;
        while (num > 0) {
            d = num % 10;
            sum += d * d;
            num = num / 10;
        }
        return sum;
    }

}
