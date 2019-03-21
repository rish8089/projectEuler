package com.java.rishabh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PanDigitalMultiples {

    int lim = 9999;

    public int getLargestPandigitalMultiple() {
        int ans = 0;

        int visited[] = new int[10];

        for (int i = 1; i <= lim; i++) {
            int j = 1;
            int cntOfDigits = 0;
            int s = 0;
            Arrays.fill(visited, 0);
            boolean flag = true;
            while (true) {
                List<Integer> listOfDigits = getDigits(i * j);

                for (int digit : listOfDigits) {

                    if (digit == 0 || visited[digit] == 1) {
                        flag = false;
                        break;
                    }

                    visited[digit] = 1;
                }

                if (!flag) {
                    break;
                }

                cntOfDigits += listOfDigits.size();

                if (cntOfDigits > 9) {
                    break;
                }

                s = s * ((int) Math.pow(10, listOfDigits.size())) + (i * j);

                if (cntOfDigits == 9) {
                    System.out.println("panDigital = (" + i + "," + s + ")");
                    if (ans < s) {
                        ans = s;
                    }
                }

                j++;
            }
        }
        return ans;
    }

    List<Integer> getDigits(int num) {

        List<Integer> digits = new ArrayList<>();

        int d = 0;
        while (num > 0) {
            d = d + 1;
            digits.add(num % 10);
            num = num / 10;
        }
        return digits;
    }

}
