package com.java.rishabh;

import java.util.HashSet;

public class AlmostEquilateralTriangles {

    int lim = 1000000000;

    public long getSumOfPerimetersOfAlmostEquilateralTriangles() {
        long i = 1;
        long square;
        long a;
        long b;
        long sum = 0;
        long a1Lim = (lim - 1) / 3;
        long a2Lim = (lim + 1) / 3;
        HashSet<Long> hashSet = new HashSet<>();
        while (true) {
            square = i * i;

            if (square + 1 <= a1Lim) {
                if (!hashSet.contains(square + 1)) {
                    a = square + 1;
                    b = 3 * a + 1;
                    if (a % 2 != 0 && isPerfectSquare(b) && ((a - 1) % 4 == 0 || b % 4 == 0)) {
                        if (isPerfectSquare(((a - 1) * b) / 4)) {
                            sum += (3 * a + 1);
                            hashSet.add(a);
                        }
                    }
                }

                if (2*square+1<=a1Lim && !hashSet.contains(2 * square + 1)) {
                    a = 2 * square + 1;
                    if (a % 2 != 0 && (3 * a + 1) % 2 == 0) {
                        b = (3 * a + 1) / 2;
                        if (isPerfectSquare(b)) {
                            sum += 3 * a + 1;
                            hashSet.add(a);
                        }
                    }
                }

            } else {
                break;
            }

            i++;
        }
        hashSet.clear();


        i = 1;
        while (true) {
            square = i * i;
            if (square - 1 <= a2Lim) {
                if(!hashSet.contains(square-1)) {
                    a = square - 1;
                    b = 3 * a - 1;
                    if (a % 2 != 0 && ((a + 1) % 4 == 0 || b % 4 == 0)) {
                        if (isPerfectSquare(((a + 1) * b) / 4)) {
                            sum += (3 * a - 1);
                        }
                    }
                }

                if (2*square-1<=a2Lim && !hashSet.contains(2 * square - 1)) {
                    a = 2 * square - 1;
                    if (a!=1 && a % 2 != 0 && (3 * a - 1) % 2 == 0) {
                        b = (3 * a - 1) / 2;
                        if (isPerfectSquare(b)) {
                            sum += 3 * a - 1;
                            hashSet.add(a);
                        }
                    }
                }
            } else {
                break;
            }
            i++;
        }

        return sum;
    }

    private boolean isPerfectSquare(long num) {
        long sqrt = (long) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
