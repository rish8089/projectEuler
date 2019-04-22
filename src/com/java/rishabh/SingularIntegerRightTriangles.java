package com.java.rishabh;

public class SingularIntegerRightTriangles {

    int L = 1500000;
    int rightAngledTriangles[];

    SingularIntegerRightTriangles() {
        rightAngledTriangles = new int[L + 1];
    }

    public int getNoOfSingularIntegerRightTriangles() {
        int mLim = (int) Math.sqrt(L / 2);
        for (int m = 2; m < mLim; m++) {
            for (int n = 1; n < m; n++) {
                if ((m + n) % 2 != 0 && gcd(m, n) == 1) {

                    int a = m * m - n * n;
                    int b = 2 * m * n;
                    int c = m * m + n * n;

                    int k = 1;
                    while (a*k+b*k+c*k<=L) {
                        rightAngledTriangles[a*k + b*k + c*k]++;
                        k++;
                    }


                }
            }
        }

        System.out.println(rightAngledTriangles[120]);
        int res = 0;
        for (int i = 1; i <= L; i++) {
            if (rightAngledTriangles[i] == 1) {
                res++;
            }
        }
        return res;
    }

    private int gcd(int m, int n) {
        if (n == 0) {
            return m;
        } else {
            return gcd(n, m % n);
        }
    }
}
