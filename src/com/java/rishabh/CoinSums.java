package com.java.rishabh;

public class CoinSums {

    int lim=200;
    long A[][];
    int coinValues[];

    CoinSums()
    {
        A=new long[lim+1][8];
        coinValues=new int[8];
        coinValues[0]=1;
        coinValues[1]=2;
        coinValues[2]=5;
        coinValues[3]=10;
        coinValues[4]=20;
        coinValues[5]=50;
        coinValues[6]=100;
        coinValues[7]=200;
    }

    public long getNoOfWaysToConstructLim()
    {
        for(int i=1;i<=200;i++)
        {
            for(int j=0;j<8;j++)
            {
                if(i>=coinValues[j])
                {
                    if(i==coinValues[j])
                        A[i][j]+=1;
                    else
                    {
                        //starting element is coinValues[j]
                        for(int k=j;k<8;k++)
                            A[i][j]+=A[i-coinValues[j]][k];
                    }
                }
            }
        }

        long sum=0;

        for(int i=0;i<8;i++)
            sum=sum+A[lim][i];

        return sum;

    }


}
