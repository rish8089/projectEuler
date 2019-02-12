package com.java.rishabh;

public class AmicableNumbers {

    int sumOfDivisors[];
    int lim=10000;

    AmicableNumbers()
    {
        sumOfDivisors=new int[lim];
    }

    public int getSumOfAmicableNumbers()
    {
        precalculateSumOfDivisors();

        int total=0,j;

        for(int i=2;i<lim;i++)
        {
            j=sumOfDivisors[i];
            if(j<lim && i<j && sumOfDivisors[j]==i)
            {
                //i and j are amicable numbers
                total=total+i+j;

            }
        }
        return total;
    }





    private void precalculateSumOfDivisors()
    {
        for(int i=2;i<lim;i++)
        {
            sumOfDivisors[i]=1;
            for(int j=2;j*j<=i;j++)
            {
                if(i%j==0)
                {
                    sumOfDivisors[i]+=j;
                    if(i/j!=j)
                        sumOfDivisors[i]+=i/j;

                }
            }
        }
    }



}
