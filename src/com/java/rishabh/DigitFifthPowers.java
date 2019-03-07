package com.java.rishabh;


/**
 *
 * In this question we have to find the sum of all such numbers which have sum of fifth power of their digits equal to them
 *
 * lets see for fourth power example
 * 1634 = 14 + 64 + 34 + 44
 *
 * Here the key to soln is to find the range of number till we have to check.
 * (9^5+9^5+9^5+9^5+9^5+9^5+9^5)=354294
 * any number greater than 354294 cannot be expressed as sum of fifth power of their digits.
 *
 *
 *
 */
public class DigitFifthPowers {

    int lim=354294;

    public int getSumOfNumbers(){

        int ans=0;

        for(int i=10;i<=lim;i++)
        {
            int num=i;

            int sumOfFifthPowerOfDigits=0;

            while(num>0)
            {
                int x=num%10;
                sumOfFifthPowerOfDigits+=x*x*x*x*x;
                num=num/10;
            }

            if(sumOfFifthPowerOfDigits==i)
            {
                ans=ans+sumOfFifthPowerOfDigits;
            }
        }
        return ans;
    }

}
