package com.java.rishabh;

import java.util.ArrayList;
import java.util.List;

public class ConsecutivePrimeSum {

    int lim = 1000000;
    boolean sieve[];
    long dp[];

    ConsecutivePrimeSum() {
        sieve = new boolean[lim + 1];
    }

    public long getPrimeConsistingOfLargestNoOfPrimes() {
        calculatePrimes();

        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= lim; i++) {
            if (!sieve[i]) {
                primes.add(i);
            }
        }



        dp=new long[primes.size()];

        dp[0]=primes.get(0);
        for(int i=1;i<primes.size();i++)
        {
            dp[i]=dp[i-1]+primes.get(i);
        }

        int longestRange=0;
        long ans=0;
        for(int i=0;i<primes.size();i++)
        {
            for(int j=i+longestRange+1;j<primes.size();j++)
            {
                if(i==0)
                {
                    if(dp[j]<=lim && !sieve[(int)dp[j]])
                    {
                        ans=dp[j];
                        longestRange=j-i+1;
                    }
                }
                else
                {
                    if(dp[j]<=lim && !sieve[(int)(dp[j]-dp[i-1])])
                    {
                        ans=dp[j]-dp[i-1];
                        longestRange=j-i+1;
                    }
                }
            }
        }

        return ans;

    }

    private void calculatePrimes() {
        sieve[0] = true;
        sieve[1] = true;
        for (int i = 2; i * i <= lim; i++) {
            if (!sieve[i]) {
                for (int j = i * i; j <= lim; j += i) {
                    sieve[j] = true;
                }
            }
        }

    }
}
