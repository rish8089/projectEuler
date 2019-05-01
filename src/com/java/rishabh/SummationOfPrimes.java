package com.java.rishabh;

public class SummationOfPrimes {

    int lim=2000000;
    boolean sieve[];

    SummationOfPrimes()
    {
        sieve=new boolean[lim];
    }

    public long getSumOfPrimes()
    {
        for(int i=2;i*i<lim;i++)
        {
            if(!sieve[i]) {
                for (int j = i * i; j < lim; j += i)
                    sieve[j] = true;
            }
        }

        long ans=0;
        int cnt=0;

        for(int i=2;i<lim;i++)
        {
            if(!sieve[i]) {
                ans = ans + i;
                cnt+=1;
                if(cnt==10001)
                    return i;
            }
        }
        return ans;
    }

}
