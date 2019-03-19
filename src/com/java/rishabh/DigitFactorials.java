package com.java.rishabh;

public class DigitFactorials {

    int lim=9999999;

    int factorial[];

    public long getSumOfNumbersWhichAreEqualToSumOfFactorialOfDigits()
    {

        long ans=0;

        factorial=new int[10];
        factorial[0]=1;

        for(int i=1;i<=9;i++)
            factorial[i]=i*factorial[i-1];

        for(int i=10;i<=lim;i++)
        {
            if(getSumOfFactorialOfDigits(i)==i) {
                System.out.println("i = " + i);
                ans = ans + i;
            }
        }
        
        return ans;

    }

    private int getSumOfFactorialOfDigits(int num)
    {
        int sum=0;
        while(num>0)
        {
            int x=num%10;
            sum+=factorial[x];
            num=num/10;
        }
        return sum;
    }

}
