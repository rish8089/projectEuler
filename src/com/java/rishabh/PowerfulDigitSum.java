package com.java.rishabh;

import java.util.Arrays;

public class PowerfulDigitSum {

    int lim=100;

    public int getPowerfulDigitSum()
    {

        int ans=0;
        int arr[];
        int A[]=new int[2*lim+1];
        int B[]=new int[2*lim+1];

        for(int i=2;i<lim;i++)
        {
            int noOfDigitsInA=populateArrayWithDigits(A,1);
            int noOfDigitsInB=populateArrayWithDigits(B,i);

            for(int j=1;j<lim;j++)
            {
                A=multiplyTwoArrays(A,B,noOfDigitsInA,noOfDigitsInB);
                noOfDigitsInA=getNoOfDigitsInArray(A);

                int sumOfDigits=getSumOfDigitsInArray(A);
                if(ans<sumOfDigits) {
                    ans = sumOfDigits;
                }

            }



            Arrays.fill(A,0);
            Arrays.fill(B,0);


        }



        return ans;


    }

    private int populateArrayWithDigits(int arr[],int num)
    {

        int idx=arr.length-1;
        while(num>0)
        {
            arr[idx]=num%10;
            num=num/10;
            idx--;
        }

        return arr.length-1-idx;
    }

    int[] multiplyTwoArrays(int[] A, int[] B, int noOfDigitsInA, int noOfDigitsInB) {
        int tmp[] = new int[2*lim+1];

        for (int j = 2*lim; j > 2*lim-noOfDigitsInB; j--) {
            int carry = 0;

            int idx = j;

            for (int k = 2*lim; k > (2*lim-noOfDigitsInA) && idx >= 0; k--, idx--) {
                int prod = carry + B[j] * A[k];
                addNumToArrayAtIdx(tmp, prod % 10, idx);
                carry = prod / 10;
            }

            if (idx >= 0 && carry > 0) {
                addNumToArrayAtIdx(tmp, carry, idx);
            }

        }

        return tmp;

    }

    private int getNoOfDigitsInArray(int arr[]) {
        int idx = 0;
        while (idx < arr.length && arr[idx] == 0) {
            idx++;
        }
        return arr.length - idx;
    }

    private int getSumOfDigitsInArray(int arr[])
    {
        int idx=0;
        while (idx < arr.length && arr[idx] == 0) {
            idx++;
        }

        int sum=0;
        while(idx<arr.length)
        {
            sum=sum+arr[idx];
            idx++;
        }
        return sum;
    }



    private void addNumToArrayAtIdx(int tmp[], int num, int idx) {
        int addition = tmp[idx] + num;
        tmp[idx] = addition % 10;
        int carry = addition / 10;
        idx--;
        while (idx >= 0 && carry > 0) {
            addition = carry + tmp[idx];
            tmp[idx] = addition % 10;
            carry = addition / 10;
            idx--;


        }
    }

}
