package com.java.rishabh;

import java.util.Arrays;

public class PowerfulDigitCounts {

    int lim=200;
    int A[]=new int[lim];
    int B[]=new int[lim];

    public int getPowerfulDigitCounts()
    {
        int cnt=1;

        for(int i=2;i<=9;i++)
        {
            int j=1;
            Arrays.fill(A,0);
            Arrays.fill(B,0);
            populateArrayWithDigits(A,1);
            populateArrayWithDigits(B,i);
            while(true)
            {
                A=multiplyTwoArrays(A,B,getNoOfDigitsInArray(A),getNoOfDigitsInArray(B));

                int d=getNoOfDigitsInArray(A);
                if(d==j)
                    cnt+=1;
                else if(d<j)
                    break;


                j++;
            }
        }

        return cnt;
    }

    private int getNoOfDigitsInArray(int arr[]) {
        int idx = 0;
        while (idx < arr.length && arr[idx] == 0) {
            idx++;
        }
        return arr.length - idx;
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
        int tmp[] = new int[lim];

        for (int j = lim-1; j > lim-1-noOfDigitsInB; j--) {
            int carry = 0;

            int idx = j;

            for (int k = lim-1; k > (lim-1-noOfDigitsInA) && idx >= 0; k--, idx--) {
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
