package com.java.rishabh;

public class PowerDigitSum {


    private int arr[];
    private int arr2[];
    int lim=1000;

    PowerDigitSum()
    {
        arr=new int[2*lim+1];
        arr2=new int[2*lim+1];
    }

    public int getDigitsSum()
    {
        int sum=0;
        populateArrayWithDigits(arr,2);
        populateArrayWithDigits(arr2,2);

        int i=2;
        while(i<=1000) {
            arr = multiplyTwoArrays(arr, arr2, getNoOfDigitsInArray(arr),
                getNoOfDigitsInArray(arr2));
            i++;
        }

        for(i=0;i<arr.length;i++)
            sum+=arr[i];

        return sum;


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

    private int getNoOfDigitsInArray(int arr[]) {
        int idx = 0;
        while (idx < arr.length && arr[idx] == 0) {
            idx++;
        }
        return arr.length - idx;
    }




}
