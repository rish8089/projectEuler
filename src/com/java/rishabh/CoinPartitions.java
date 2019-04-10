package com.java.rishabh;

public class CoinPartitions {

    int lim = 1000;
    int dp[][][];
    int digitsLim = 100;

    CoinPartitions() {
        dp = new int[lim + 1][lim + 1][digitsLim + 1];
    }

    public int getCoinPartitions() {
        populateArrayWithDigits(dp[1][1], 1);

        for (int i = 2; i <= lim; i++) {
            for (int j = 1; j <= i; j++) {
                if (i == j) {
                    addTwoArrays(dp[i][j], dp[i][j - 1], getNoOfDigitsInArray(dp[i][j]),
                        getNoOfDigitsInArray(dp[i][j - 1]));
                    addNumToArrayAtIdx(dp[i][j], 1, digitsLim);
                } else {
                    addTwoArrays(dp[i][j], dp[i][j - 1], getNoOfDigitsInArray(dp[i][j]),
                        getNoOfDigitsInArray(dp[i][j - 1]));
                    int minIdx = min(j, i - j);
                    addTwoArrays(dp[i][j], dp[i - j][minIdx], getNoOfDigitsInArray(dp[i][j]),
                        getNoOfDigitsInArray(dp[i - j][minIdx]));
                }
            }

            int noOfDigits=getNoOfDigitsInArray(dp[i][i]);
            int cnt=getNoOfZerosInLast(dp[i][i],noOfDigits);
            if(cnt>=6)
                return i;
        }

        return -1;
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

        int minIdx=min(i,j);
        if(carry>0)
            A[minIdx]+=carry;
    }

    private int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    private int getNoOfDigitsInArray(int arr[]) {
        int idx = 0;
        while (idx < arr.length && arr[idx] == 0) {
            idx++;
        }
        return arr.length - idx;
    }

    private int getNoOfZerosInLast(int arr[],int noOfDigits)
    {
        int i=digitsLim;
        int cnt=0;
        while(i>(digitsLim-noOfDigits))
        {
            if(arr[i]==0)
                cnt+=1;
            else
                break;
            i--;
        }

        return cnt;
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
