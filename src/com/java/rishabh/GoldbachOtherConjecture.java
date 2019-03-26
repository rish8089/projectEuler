package com.java.rishabh;

public class GoldbachOtherConjecture {

    public int getSmallestCompositeNumber()
    {
        int i=9;
        while(true)
        {
            int k=1;
            boolean flag=true;
            while(i-2*k*k>=2)
            {
                if(isPrime(i-2*k*k)) {
                    flag = false;
                    break;
                }
                k++;
            }

            if(flag)
                return i;

            i+=2;
            while(isPrime(i))
            {
                i+=2;
            }
        }
    }

    boolean isPrime(int num)
    {
        if(num==1 || num==0)
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
