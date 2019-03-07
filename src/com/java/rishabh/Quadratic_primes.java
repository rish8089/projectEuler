package com.java.rishabh;

public class Quadratic_primes {

    int alim=999;
    int blim=1000;

    public int getProductOfCoefficientsWithMaximumNoOfConsecutivePrimes()
    {

        int maxCnt=0;
        int prod=0;

        for(int i=-alim;i<=alim;i++) {

            for (int j = -blim; j <= blim; j++) {

                int n=0;
                int cnt=0;

                while(true)
                {
                    int num=n*n+i*n+j;
                    if(num>=2)
                    {
                        if(!isPrime(num))
                          break;
                        else
                            cnt+=1;
                    }
                    else
                        break;

                    n=n+1;

                }

                if(maxCnt<cnt) {
                    maxCnt = cnt;
                    prod = i * j;
                }

            }

        }
        return prod;


    }

    boolean isPrime(int num)
    {

        for(int i=2;i*i<=num;i++)
        {
            if(num%i==0)
            {
                return false;
            }
        }

        return true;
    }

}
