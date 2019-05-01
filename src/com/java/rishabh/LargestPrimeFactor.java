package com.java.rishabh;

public class LargestPrimeFactor {

    long lim=600851475143l;

    public long getLargestPrimeFactor()
    {
        long i=2;
        long ans=0;

        while(i*i<=lim)
        {
            if(lim%i==0)
            {
                while(lim%i==0)
                    lim=lim/i;

                if(ans<i)
                    ans=i;
            }


            i+=1;

        }

        if(lim>1)
        {
            if(ans<lim)
                ans=lim;
        }

        return ans;
    }

}
