package com.java.rishabh;

import java.util.ArrayList;
import java.util.List;

public class TruncatablePrimes {

    public long getSumOfTruncatablePrimes()
    {
        int cnt=11;
        long ans=0;

        int num=10;

        while(cnt>0)
        {

            if (isTruncatablePrime(num)) {
                System.out.println("num = " + num);
                ans=ans+num;
                cnt--;
            }

            num++;
        }
        return ans;
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

    boolean isTruncatablePrime(int num)
    {
        int numTmp=num;

        while(num>0)
        {
            if(!isPrime(num)) {
                return false;
            }
            num=num/10;
        }

        num=numTmp;

        List<Integer> digits=getDigits(num);

        for(int i=digits.size()-1;i>0;i--)
        {
            num=num-digits.get(i)*((int)Math.pow(10,i));
            if(!isPrime(num))
            {
                return false;
            }

        }

        return true;


    }

    List<Integer> getDigits(int num)
    {

        List<Integer> digits=new ArrayList<>();

        int d=0;
        while(num>0)
        {
            d=d+1;
            digits.add(num%10);
            num=num/10;
        }
        return digits;
    }

}
