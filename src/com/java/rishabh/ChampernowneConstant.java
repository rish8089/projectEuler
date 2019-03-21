package com.java.rishabh;

import java.util.ArrayList;
import java.util.List;

public class ChampernowneConstant {

    int lim = 1000000;
    List<Integer> sumOfNumOfDigits;

    ChampernowneConstant() {
        sumOfNumOfDigits = new ArrayList<>();

    }

    public int getChampernowneConstant() {
        int i = 1;
        int prod=1;
        int numOfDigits = 0; //single digit numbers, i=2 ->double digit numbers

        while (numOfDigits <= lim) {
            numOfDigits = numOfDigits + 9 * ((int) Math.pow(10, i - 1))*i;
            sumOfNumOfDigits.add(numOfDigits);

            i++;
        }

        int A[] = {1, 10, 100, 1000,10000, 100000, 1000000};

        for (i = 0; i < A.length; i++) {

            int j = 0;
            while (sumOfNumOfDigits.get(j) < A[i]) {
                j++;
            }

            //use the value of j to reach in digits section
            int numOfDigitsDiff;
            if (j == 0) {
                numOfDigitsDiff=A[i];
            } else {
                numOfDigitsDiff=A[i]-sumOfNumOfDigits.get(j-1);
            }

            int finalNum=(((int)Math.pow(10,j))-1)+numOfDigitsDiff/(j+1)+((numOfDigitsDiff%(j+1)>0)?1:0);
            int rem=(numOfDigitsDiff%(j+1)==0)?j+1:numOfDigitsDiff%(j+1);
            prod=prod*getNthDigitOfNum(finalNum,rem);

        }
        return prod;
    }

    private int getNthDigitOfNum(int num,int n)
    {
        int s=0;
        while(num>0)
        {
            int x=num%10;
            num=num/10;
            s=s*10+x;
        }

        num=s;
        int j=1;
        while(num>0)
        {
            int x=num%10;
            if(j==n)
                return x;
            num=num/10;
            j++;
        }

        return -1;
    }

}
