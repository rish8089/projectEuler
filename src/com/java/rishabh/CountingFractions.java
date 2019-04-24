package com.java.rishabh;

public class CountingFractions {

    int D=1000000;

    public long getNoOfFractions()
    {
        long ans=0;
        long totientNumerator;
        long totientDenominator;

        for(int i=2;i<=D;i++)
        {
            int n=i;
            totientNumerator=i;
            totientDenominator=1;
            int j=2;
            while(j*j<=n)
            {
                boolean flag=false;
                while(n%j==0) {
                    n = n / j;
                    flag = true;
                }

                if(flag)
                {
                    totientNumerator=totientNumerator*(j-1);
                    totientDenominator*=j;
                }

                j++;

            }

            if(n>1)
            {
                totientNumerator=totientNumerator*(n-1);
                totientDenominator*=n;
            }

            ans+=totientNumerator/totientDenominator;
        }

        return ans;

    }
}
