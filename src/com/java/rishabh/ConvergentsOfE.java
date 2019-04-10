package com.java.rishabh;

import java.util.Arrays;

public class ConvergentsOfE {


    int lim = 99;
    int digitsLim = 100;

    public long getNumeratorOf100thConvergentOfE() {
        Fraction fraction = recurse(1);
        int A[] = new int[digitsLim+1];
        populateArrayWithDigits(A,2);
        int tmp[] =multiplyTwoArrays(fraction.d ,A,getNoOfDigitsInArray(fraction.d),getNoOfDigitsInArray(A));
        addTwoArrays(tmp,fraction.n,getNoOfDigitsInArray(tmp),getNoOfDigitsInArray(fraction.n));
        return getSumOfDigitsInArr(tmp,getNoOfDigitsInArray(tmp));
    }

    private Fraction recurse(int i) {
        if (i == lim) {
            Fraction fraction = new Fraction();
            if (i % 3 == 1 || i % 3 == 0) {
                populateArrayWithDigits(fraction.n, 1);
                populateArrayWithDigits(fraction.d, 1);
            } else {
                populateArrayWithDigits(fraction.n, 1);
                populateArrayWithDigits(fraction.d, 2 * (i + 1) / 3);
            }
            return fraction;
        }

        Fraction convergent = new Fraction();
        if (i % 3 == 1 || i % 3 == 0) {
            populateArrayWithDigits(convergent.n, 1);
            populateArrayWithDigits(convergent.d, 1);
        } else {
            populateArrayWithDigits(convergent.n, 1);
            populateArrayWithDigits(convergent.d, 2 * (i + 1) / 3);
        }

        Fraction ret = recurse(i + 1);

        int tmp[] = multiplyTwoArrays(convergent.d, ret.d, getNoOfDigitsInArray(convergent.d),
            getNoOfDigitsInArray(ret.d));
        addTwoArrays(tmp, ret.n, getNoOfDigitsInArray(tmp), getNoOfDigitsInArray(ret.n));
        convergent.d = Arrays.copyOf(tmp,digitsLim+1);
        convergent.n = Arrays.copyOf(ret.d,digitsLim+1);
        return convergent;

    }

    class Fraction {

        int[] n;
        int[] d;

        Fraction() {
            n = new int[digitsLim + 1];
            d = new int[digitsLim + 1];
        }
    }

    int[] multiplyTwoArrays(int[] A, int[] B, int noOfDigitsInA, int noOfDigitsInB) {
        int tmp[] = new int[digitsLim+1];

        for (int j = digitsLim ; j > digitsLim- noOfDigitsInB; j--) {
            int carry = 0;

            int idx = j;

            for (int k = digitsLim; k > (digitsLim- noOfDigitsInA) && idx >= 0; k--, idx--) {
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

    private int populateArrayWithDigits(int arr[], int num) {

        Arrays.fill(arr, 0);
        int idx = arr.length - 1;
        while (num > 0) {
            arr[idx] = num % 10;
            num = num / 10;
            idx--;
        }

        return arr.length - 1 - idx;
    }

    private int getNoOfDigitsInArray(int arr[]) {
        int idx = 0;
        while (idx < arr.length && arr[idx] == 0) {
            idx++;
        }
        return arr.length - idx;
    }

    private void addTwoArrays(int A[], int B[], int noOfDigitsInA, int noOfDigitsInB) {

        int i = digitsLim, j = digitsLim;
        int carry = 0;
        while (i > (digitsLim - noOfDigitsInA) && j > (digitsLim - noOfDigitsInB)) {
            int sum = carry + A[i] + B[j];
            A[i] = sum % 10;
            carry = sum / 10;
            i--;
            j--;
        }

        while (i > (digitsLim - noOfDigitsInA)) {
            int sum = carry + A[i];
            A[i] = sum % 10;
            carry = sum / 10;
            i--;
        }

        while (j > (digitsLim - noOfDigitsInB)) {
            int sum = carry + B[j];
            A[j] = sum % 10;
            carry = sum / 10;
            j--;
        }

        int minIdx = min(i, j);
        if (carry > 0) {
            A[minIdx] += carry;
        }
    }


    private int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    private int getSumOfDigitsInArr(int arr[],int noOfDigits)
    {
        int i=digitsLim;
        int sum=0;
        while(i>digitsLim-noOfDigits)
        {
            sum=sum+arr[i];
            i--;
        }

        return sum;
    }


}
