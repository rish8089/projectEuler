package com.java.rishabh;

import java.util.ArrayList;
import java.util.List;

public class PermutedMultiples {

    public int getPermutedMultiple() {
        for (int i = 1; true; i++) {
            List<Integer> digits = getDigits(i);
            int d6 = getNoOfDigits(6 * i);
            if (digits.size() == d6) {
                if (isPermutation(2 * i, digits) && isPermutation(3 * i, digits) && isPermutation(
                    4 * i, digits) && isPermutation(5 * i, digits) && isPermutation(6*i,digits)) {

                    return i;

                }
            }
        }
    }

    private int getNoOfDigits(int num) {
        int d = 0;

        while (num > 0) {
            d = d + 1;
            num = num / 10;
        }
        return d;
    }

    private List<Integer> getDigits(int num) {
        List<Integer> digits = new ArrayList<>();

        while (num > 0) {
            digits.add(num % 10);
            num = num / 10;
        }

        return digits;
    }

    private boolean isPermutation(int num, List<Integer> digits) {
        List<Integer> digits1 = new ArrayList<>();

        while (num > 0) {
            digits1.add(num % 10);
            num = num / 10;
        }

        int initialSize = digits.size();
        digits.retainAll(digits1);

        if (digits.size() == initialSize) {
            return true;
        } else {
            return false;
        }
    }


}
