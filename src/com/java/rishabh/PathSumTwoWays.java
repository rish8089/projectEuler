package com.java.rishabh;

import java.io.BufferedReader;
import java.io.IOException;

public class PathSumTwoWays {

    int M = 80;
    int N = 80;
    int matrix[][];
    int dp[][];
    BufferedReader br;

    PathSumTwoWays(BufferedReader br) {
        matrix = new int[M + 1][N + 1];
        dp = new int[M + 1][N + 1];
        this.br = br;
    }

    public void processInput() throws IOException {
        for (int i = 1; i <= M; i++) {
            String str[] = br.readLine().split(",");
            for (int j = 0; j < str.length; j++) {
                matrix[i][j + 1] = Integer.parseInt(str[j]);
            }
        }
    }

    public int getMinimumPathSum() {

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {

                if (i - 1 >= 1 && j - 1 >= 1) {
                    dp[i][j] = matrix[i][j] + min(dp[i - 1][j], dp[i][j - 1]);
                } else if (i - 1 >= 1) {
                    dp[i][j] = matrix[i][j] + dp[i - 1][j];
                } else if (j - 1 >= 1) {
                    dp[i][j] = matrix[i][j] + dp[i][j - 1];
                }
                else
                    dp[i][j]=matrix[i][j];

            }
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(dp[i][j] + " ");
            }

            System.out.println();
        }

        return dp[M][N];

    }

    private int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

}
