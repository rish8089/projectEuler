package com.java.rishabh;

public class DigitFibonacciNumber {

    int A[];
    int B[];
    int C[];
    int lim=1000;

    public int getFibonacciSmallestNumberIndexContainingThousandDigits()
    {
       A=new int[lim];
       B=new int[lim];
       C=new int[lim];

       A[lim-1]=1;
       B[lim-1]=1;

       int idx=3;

       int curr_no_of_digits_in_B=1;
       while(true)
       {
           curr_no_of_digits_in_B=getNoOfDigitsInSumOfTwoArrays(curr_no_of_digits_in_B);

           if(curr_no_of_digits_in_B==1000)
               return idx;
           idx=idx+1;
       }



    }

    private int getNoOfDigitsInSumOfTwoArrays(int curr_no_of_digits_in_B)
    {
        int carry=0,i;


        for(i=lim-1;i>=lim-curr_no_of_digits_in_B;i--)
        {
            C[i]=(A[i]+B[i]+carry)%10;
            carry=(A[i]+B[i]+carry)/10;
        }

        if(carry>0)
        {
            C[i]=carry;
            curr_no_of_digits_in_B=curr_no_of_digits_in_B+1;
        }

        for(i=lim-1;i>=lim-curr_no_of_digits_in_B;i--)
            A[i]=B[i];

        for(i=lim-1;i>=lim-curr_no_of_digits_in_B;i--)
            B[i]=C[i];


        return curr_no_of_digits_in_B;
    }




}
