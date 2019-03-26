package com.java.rishabh;

import java.util.Arrays;

public class SelfPowers {

    public long getSumOfSelfPowersUptoLastTenDigits() {

        int sum[] = new int[10];
        int A[] = new int[10];
        int B[] = new int[10];

        for (int i = 1; i <= 1000; i++) {
            Arrays.fill(A, 0);
            Arrays.fill(B, 0);
            int num = i;
            int endIndex = 9;

            while (num > 0) {
                A[endIndex] = num % 10;
                B[endIndex] = num % 10;
                endIndex--;
                num = num / 10;
            }

            num = i;
            while (num > 1) {
                A = multiplyTwoArrays(A, B, getNoOfDigitsInArray(A), 9 - endIndex);
                num--;
            }

            int carry = 0;
            for (int j = 9; j >= 0; j--) {
                int addition = carry + A[j] + sum[j];
                sum[j] = addition % 10;
                carry = addition / 10;
            }

        }

        long res = 0;

        for (int i = 0; i <= 9; i++) {
            res = res * 10 + sum[i];
        }

        return res;


    }

    int[] multiplyTwoArrays(int[] A, int[] B, int noOfDigitsInA, int noOfDigitsInB) {
        int tmp[] = new int[10];

        for (int j = 9; j > 9 - noOfDigitsInB; j--) {
            int carry = 0;

            int idx = j;

            for (int k = 9; k > 9 - noOfDigitsInA && idx >= 0; k--, idx--) {
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
