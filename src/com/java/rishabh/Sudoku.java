package com.java.rishabh;

import java.io.BufferedReader;
import java.io.IOException;

public class Sudoku {

    private BufferedReader br;
    int A[][][];
    int N = 1;
    boolean visited[][][];


    Sudoku(BufferedReader br) {
        this.br = br;
        A = new int[N][9][9]; //9x9 sudoko
        visited = new boolean[N][9][9];

    }

    public void processInput() throws IOException {
        for (int grid = 0; grid < N; grid++) {
            br.readLine();
            for (int i = 0; i < 9; i++) {
                String str = br.readLine();
                for (int j = 0; j < 9; j++) {
                    A[grid][i][j] = str.charAt(j) - '0';
                }

            }
        }
    }

    public int solve() {
        int sum = 0;

        for (int grid = 0; grid < N; grid++) {
            recurse(grid);
            sum+=A[grid][0][0]*100+A[grid][0][1]*10+A[grid][0][2];
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(A[0][i][j] + " ");
            }

            System.out.println();
        }


        return sum;
    }

    private boolean recurse(int grid) {

        int solutionGridRow, solutionGridColumn;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (A[grid][i][j] == 0 && !visited[grid][i][j]) {

                    solutionGridRow = i / 3;
                    solutionGridColumn = j / 3;
                    int hash[] = new int[10];

                    for (int k = 0; k < 9; k++) {
                        if (A[grid][i][k] != 0) {
                            hash[A[grid][i][k]] = 1;
                        }
                    }

                    for (int k = 0; k < 9; k++) {
                        if (A[grid][k][j] != 0) {
                            hash[A[grid][k][j]] = 1;
                        }
                    }

                    for (int k = solutionGridRow * 3; k < solutionGridRow * 3 + 3; k++) {
                        for (int l = solutionGridColumn * 3; l < solutionGridColumn * 3 + 3; l++) {
                            if (A[grid][k][l] != 0) {
                                hash[A[grid][k][l]] = 1;
                            }
                        }
                    }

                    boolean flag = false;

                    for (int k = 1; k <= 9; k++) {
                        if (hash[k] == 0) {
                            A[grid][i][j] = k;

                            flag = true;
                            visited[grid][i][j] = true;
                            boolean ret = recurse(grid);
                            visited[grid][i][j] = false;

                            if (ret) //got some solution
                            {
                                return true;
                            } else {
                                A[grid][i][j] = 0; //backtrack
                                flag = false;
                            }


                        }
                    }

                    if(!flag)
                        return false;



                }
            }
        }

        return true;
    }
}
