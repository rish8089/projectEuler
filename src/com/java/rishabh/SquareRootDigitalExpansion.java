package com.java.rishabh;

import java.util.Arrays;

public class SquareRootDigitalExpansion {

    int lim = 100;
    int digitalDigitsLim = 100;
    int A[];

    SquareRootDigitalExpansion() {
        A = new int[2 * digitalDigitsLim + 1];
    }

    public long getTotalSumOfFirstHundredDigits() {
        long totalSum = 0;
        for (int i = 2;i <= lim; i++) {
            int ret = isIrrationalRoot(i);
            if (ret != -1) {
                //i is perfect square, hurray!!!
                Arrays.fill(A, 0);
                populateArrayWithDigits(A, ret);
                int j = 1;
                int sum = 0;
                while (j < digitalDigitsLim) {
                    shiftArrayByOne(A);
                    int k;
                    for (k = 1; k <= 9; k++) {
                        A[A.length - 1] = k;
                        int tmp[] = multiplyTwoArrays(A, A, getNoOfDigitsInArray(A),
                            getNoOfDigitsInArray(A));
                        int num = getNumberBeforeDecimal(tmp, j * 2);//j*2 are decimal digits
                        if (num >= i) {
                            A[A.length - 1] = k - 1;
                            sum += k - 1;
                            break;
                        }
                    }

                    if (k == 10) {
                        sum += 9;
                    }
                    j++;
                }

                sum += ret;
                totalSum = totalSum + sum;

            }
        }

        return totalSum;
    }


    private int populateArrayWithDigits(int arr[], int num) {

        int idx = arr.length - 1;
        while (num > 0) {
            arr[idx] = num % 10;
            num = num / 10;
            idx--;
        }

        return arr.length - 1 - idx;
    }

    private void shiftArrayByOne(int A[]) {
        int noOfDigits = getNoOfDigitsInArray(A);
        int idx = A.length - 1 - noOfDigits;

        for (int i = idx; i < A.length - 1; i++) {
            A[i] = A[i + 1];
        }

    }

    private int isIrrationalRoot(int num) {
        int sqrt = (int) (Math.sqrt(num));
        if (sqrt * sqrt == num) {
            return -1;
        } else {
            return sqrt;
        }
    }

    private int getNoOfDigitsInArray(int arr[]) {
        int idx = 0;
        while (idx < arr.length && arr[idx] == 0) {
            idx++;
        }
        return arr.length - idx;
    }

    int[] multiplyTwoArrays(int[] A, int[] B, int noOfDigitsInA, int noOfDigitsInB) {
        int tmp[] = new int[2 * digitalDigitsLim + 1];

        for (int j = 2 * digitalDigitsLim; j > 2 * digitalDigitsLim - noOfDigitsInB; j--) {
            int carry = 0;

            int idx = j;

            for (int k = 2 * digitalDigitsLim;
                k > (2 * digitalDigitsLim - noOfDigitsInA) && idx >= 0; k--, idx--) {
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

    private int getNumberBeforeDecimal(int tmp[], int noOfDecimalDigits) {
        int noOfDigits = getNoOfDigitsInArray(tmp);
        int startingIndex = tmp.length - noOfDigits;
        int endIndex = tmp.length - noOfDecimalDigits - 1;
        int num = 0;

        while (startingIndex <= endIndex) {
            num = num * 10 + tmp[startingIndex];
            startingIndex++;
        }

        return num;
    }



}
