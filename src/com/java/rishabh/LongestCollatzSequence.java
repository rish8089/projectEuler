package com.java.rishabh;

public class LongestCollatzSequence {

    int A[];
    int lim=1000000;

    LongestCollatzSequence()
    {
        A=new int[lim];
    }

    public int getStartingNumberProducingTheLongestChain()
    {
        int longest=0;
        int ans=0;
        for(int i=1;i<lim;i++) {
            if(A[i]==0) {
                A[i]=recurse(i);
            }

            if(longest<A[i]) {
                longest = A[i];
                ans=i;
            }
        }

        return ans;
    }

    private int recurse(long i)
    {

        int ret;

        if(i==1)
            return 1;

        if(i%2!=0)
        {
            if(3*i+1<lim)
            {
                if(A[(int)(3*i+1)]!=0)
                    ret=1+A[(int)(3*i+1)];
                else
                    ret=1+recurse(3*i+1);
            }
            else
                ret=1+recurse(3*i+1);
        }
        else
        {
            if(i/2<lim)
            {
                if(A[(int)(i/2)]!=0)
                    ret=1+A[(int)(i/2)];
                else
                    ret=1+recurse(i/2);
            }
            else
                ret= 1+recurse(i/2);
        }

        if(i<lim)
            A[(int)i]=ret;

        return ret;
    }

}
