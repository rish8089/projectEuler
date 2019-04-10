package com.java.rishabh;

import java.util.ArrayList;
import java.util.List;

public class PrimePowerTriples {

    int lim=50000000;
    private boolean[] sieve;
    private boolean[] visited;
    private List<Integer> primes;

    PrimePowerTriples()
    {
        sieve=new boolean[lim+1];
        visited=new boolean[lim+1];
        primes=new ArrayList<>();
    }

    public int getNumbersBelowFiftyMillion()
    {
        calculatePrimes();

        for(int i=2;i<=lim;i++)
        {
            if(!sieve[i])
                primes.add(i);
        }
        int i=0;
        int j=0;
        int k=0;
        int cnt=0;
        long primei;
        long primej;
        long primek;
        long val1;
        long val2;
        long val3;
        long sum;

        while(i<primes.size())
        {
            primei=primes.get(i);
            val1=primei*primei;
            if(val1<lim)
            {
                j=0;
                while(j<primes.size())
                {
                    primej=primes.get(j);
                    val2=primej*primej*primej;
                    if(val2<lim)
                    {
                        k=0;
                        while(k<primes.size())
                        {
                            primek=primes.get(k);
                            val3=primek*primek*primek*primek;
                            if(val3<lim)
                            {
                                sum=val1+val2+val3;
                                if(sum<lim)
                                {
                                    if(!visited[(int)sum]) {
                                        visited[(int) sum] = true;
                                        cnt += 1;
                                    }
                                    k++;
                                }
                                else
                                    break;
                            }
                            else
                                break;
                        }
                        j++;
                    }
                    else
                        break;
                }
                i++;
            }
            else
                break;
        }

        return cnt;
    }

    private void calculatePrimes()
    {
        for(int i=2;i*i<=lim;i++)
        {
            if(!sieve[i]) {
                for (int j = i * i; j <= lim; j += i) {
                    sieve[j]=true;
                }
            }
        }
    }

}
