package com.java.rishabh;

public class CombinatoricSelections {

    long lim=1000000;

    long fact[];

    public int getValuesGreaterThanOneMillion()
    {
        fact=new long[25];

        calculateFactorials();

        int cnt=0;

        for(int i=1;i<=100;i++)
        {
            for(int j=1;j<=i/2;j++)
            {
                long prod=1;
                int k=i;
                int l=j;
                while(l>0)
                {
                    prod=prod*k;
                    k--;
                    l--;
                }

                if(prod/fact[j]>lim)
                {
                    cnt+=i-2*j+1;
                    break;
                }

            }
        }
        return cnt;
    }

    private void calculateFactorials()
    {
        fact[0]=1;
        for(int i=1;i<25;i++)
            fact[i]=fact[i-1]*i;
    }

}
