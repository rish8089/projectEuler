package com.java.rishabh;

public class HighlyDivisibleTriangularNumber {

    public long getTriangleNumberWithOverFiveHunderedDivisors() {
        int i = 1;

        while (true) {
            long sum = ((long)i) * (i + 1) / 2;

            int cnt = 0;
            for (long j = 1; j * j <= sum; j++) {
                if (sum % j == 0) {
                    if (j != sum / j) {
                        cnt += 2;
                    } else {
                        cnt += 1;
                    }
                }
            }

            if(cnt>=500)
                return sum;

            i++;
        }


    }

}
