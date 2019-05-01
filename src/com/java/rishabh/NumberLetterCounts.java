package com.java.rishabh;

public class NumberLetterCounts {

    int A[][];

    NumberLetterCounts() {
        A = new int[10][10];
        A[1][0] = 3;
        A[2][0] = 3;
        A[3][0] = 5;
        A[4][0] = 4;
        A[5][0] = 4;
        A[6][0] = 3;
        A[7][0] = 5;
        A[8][0] = 5;
        A[9][0] = 4;

        A[1][1] = 6;
        A[1][2] = 6;
        A[1][3] = 8;
        A[1][4] = 8;
        A[1][5] = 7;
        A[1][6] = 7;
        A[1][7] = 9;
        A[1][8] = 8;
        A[1][9] = 8;

        A[2][1] = 6;
        A[3][1] = 6;
        A[4][1] = 5;
        A[5][1] = 5;
        A[6][1] = 5;
        A[7][1] = 7;
        A[8][1] = 6;
        A[9][1] = 6;

    }

    public int getLettersSum() {
        int sum = 0;

        for (int i = 1; i <= 1000; i++) {

            if (i == 10) {
                sum += 3;
            } else if (i == 1000) {
                sum += 11;
            } else {
                int pos = 0;
                int n = i;
                int cntZeros = 0;
                while (n > 0) {
                    int x = n % 10;
                    if (pos == 2) {
                        if (cntZeros == 2) {
                            sum += A[x][0] + 7;
                        } else {
                            sum += A[x][0] + 10;
                        }
                    } else if (pos == 1) {
                        int num = i % 100;
                        if (num == 10) {
                            sum += 3;
                        }
                        else if (num >= 11 && num <= 19) {
                            sum += A[x][i % 10] - A[i % 10][pos - 1];
                        } else {
                            sum += A[x][pos];
                        }
                    } else {
                        sum += A[x][pos];
                    }

                    if (x == 0) {
                        cntZeros += 1;
                    }

                    pos++;
                    n /= 10;
                }
            }

            System.out.println("i = " + i + " sum = " + sum);

        }
        return sum;
    }

}
