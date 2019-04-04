package com.java.rishabh;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MaximumPathSumII {

    private int lim = 100;
    private List<List<Integer>> triangle;

    private BufferedReader br;

    MaximumPathSumII(BufferedReader br) {
        this.br = br;
        triangle=new ArrayList<>();
    }

    public void processInput() throws IOException {
        for (int i = 1; i <= lim; i++) {
            String str[] = br.readLine().split(" ");

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < str.length; j++) {
                row.add(Integer.parseInt(str[j]));
            }

            triangle.add(row);
        }
    }

    public int getMaximumSum() {
        int i = 0,ans=0;
        List<List<Integer>> dp = new ArrayList<>();
        List<Integer> dpRow = new ArrayList<>();
        dpRow.add(triangle.get(0).get(0));
        dp.add(dpRow);

        for (i = 1; i < lim; i++) {
            List<Integer> triangleRow = triangle.get(i);
            dpRow = new ArrayList<>();
            for (int j = 0; j < triangleRow.size(); j++) {
                if (j == 0) {
                    dpRow.add(triangleRow.get(j) + dp.get(i - 1).get(j));
                } else if (j == triangleRow.size() - 1) {
                    dpRow.add(triangleRow.get(j) + dp.get(i - 1).get(j - 1));
                } else {
                    dpRow.add(triangleRow.get(j)+ max(dp.get(i - 1).get(j - 1), dp.get(i - 1).get(j)));
                }
            }

            dp.add(dpRow);

        }

        dpRow = dp.get(lim-1);
        for(i=0;i<dpRow.size();i++)
        {
            if(ans<dpRow.get(i))
                ans=dpRow.get(i);
        }

        return ans;
    }

    private int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }


}
