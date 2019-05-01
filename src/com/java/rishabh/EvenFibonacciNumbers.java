package com.java.rishabh;

public class EvenFibonacciNumbers {

    int lim=4000000;

    public long getSumOfEvenFibonacciNumbers()
    {
        long sum=0;

        int a=0;
        int b=1;

        while(a+b<=lim)
        {
            int c=a+b;
            if(c%2==0)
                sum=sum+c;

            a=b;
            b=c;
        }
        return sum;
    }

}
