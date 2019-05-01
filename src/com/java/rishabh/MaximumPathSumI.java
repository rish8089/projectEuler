package com.java.rishabh;

import java.io.BufferedReader;
import java.io.IOException;

public class MaximumPathSumI {

    int dp[][];
    int A[][];
    BufferedReader br;

    MaximumPathSumI(BufferedReader br)
    {
        this.br=br;
        dp=new int[15][15];
        A=new int[15][15];
    }

    public void processInput() throws IOException {
        for(int i=0;i<15;i++)
        {
            String str[]=br.readLine().split(" ");

            for(int j=0;j<str.length;j++)
            {
                A[i][j]=Integer.parseInt(str[j]);
            }
        }
    }



    public int getMaximumPathSum()
    {
        dp[0][0]=A[0][0];
        System.out.println("dp = " + dp[0][0]);
        for(int i=1;i<15;i++)
        {
            for(int j=0;j<=i;j++)
            {
                if(i==j)
                    dp[i][j]=A[i][j]+dp[i-1][j-1];
                else if(j==0)
                    dp[i][j]=A[i][j]+dp[i-1][j];
                else
                    dp[i][j]=A[i][j]+(dp[i-1][j]<dp[i-1][j-1]?dp[i-1][j-1]:dp[i-1][j]);
            }
        }

        int ans=0;

        for(int i=0;i<15;i++)
        {
            if(ans<dp[14][i])
                ans=dp[14][i];
        }

        return ans;
    }

}
