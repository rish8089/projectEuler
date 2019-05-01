package com.java.rishabh;

public class SmallestMultiple {

    int A[];

    SmallestMultiple()
    {
        A=new int[21];
    }

    public int getSmallestMultiple()
    {
        for(int i=2;i<=20;i++)
        {
            int n=i;
            int j=2;
            while(j*j<=n)
            {
                if(n%j==0) {
                    int cnt = 0;
                    while (n % j == 0) {
                        n = n / j;
                        cnt += 1;
                    }
                    if(A[j]<cnt)
                        A[j]=cnt;
                }

                j++;

            }

            if(n>1)
            {
                if(A[n]<1)
                    A[n]=1;
            }
        }

        int prod=1;

        for(int i=1;i<=20;i++)
        {
            prod=prod*(int)Math.pow(i,A[i]);
        }

        return prod;
    }

}
