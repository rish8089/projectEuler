package com.java.rishabh;

public class DistinctPrimeFactors {


    public int getFirstNumberWithFourPrimeFactorsFollowedByThreeNumbersWithFourPrimeFactors()
    {

        for(int i=210;true;i++)
        {
            int j=1;
            while(j<=4)
            {
                int no_of_prime_factors=getNumberOfPrimeFactors(i);
                if(no_of_prime_factors!=4)
                    break;
                i++;
                j++;
            }

            if(j>4)
                return i-4 ;
        }
    }

    int getNumberOfPrimeFactors(int num)
    {
        int cnt=0;
        for(int i=2;i*i<=num;i++) {
            if(num%i==0)
            {
                if(isPrime(i))
                    cnt+=1;

                if(num/i!=i)
                {
                    if(isPrime(num/i))
                        cnt+=1;
                }
            }
        }
        return cnt;
    }

    boolean isPrime(int num)
    {

        if(num==1)
            return false;

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
