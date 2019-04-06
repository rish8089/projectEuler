package com.java.rishabh;

public class CountingSummations {

    int lim=100;
    long dp[][];

    CountingSummations()
    {
        dp=new long[lim+1][lim+1];
    }

    public long getCountingSummations()
    {
        dp[1][1]=1;
        int i,j;

        for(i=2;i<=lim;i++)
        {
            for(j=1;j<=i;j++) //combinations can start from 1 to i
            {

                if(i==j)
                    dp[i][j]=dp[i][j-1]+1;
                else
                    dp[i][j]=dp[i][j-1]+dp[i-j][min(j,i-j)];

            }
        }

        return dp[lim][lim];
    }

    private int min(int a,int b)
    {
        if(a<b)
            return a;
        else
            return b;
    }

}
