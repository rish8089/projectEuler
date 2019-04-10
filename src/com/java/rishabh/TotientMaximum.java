package com.java.rishabh;

public class TotientMaximum {

    int lim=1000000;
    long num,den;
    long maxNum=0,maxDen=1,maxN=1;

    public long getTotientMaximum()
    {
        for(int i=2;i<=10000000;i++)
        {
            int n=i;
            num=1;
            den=1;
            for(int j=2;j*j<=n;j++)
            {
                boolean flag=false;
                while(n%j==0) {
                    n = n / j;
                    flag = true;
                }

                if(flag)
                {
                    //got the prime=1
                    num*=j;
                    den*=(j-1);
                }


            }

            if(n>1)
            {
                num*=n;
                den*=(n-1);
            }

            if(num*maxDen>den*maxNum)
            {
                maxNum=num;
                maxDen=den;
                maxN=i;
            }

        }

        return maxN;
    }

}
