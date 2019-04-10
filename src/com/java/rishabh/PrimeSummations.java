package com.java.rishabh;

import java.util.ArrayList;
import java.util.List;

public class PrimeSummations {

    int lim = 1000;
    int dp[][];
    int sieve[];
    List<Integer> primes;

    PrimeSummations() {
        dp = new int[lim + 1][lim + 1];
        sieve = new int[lim + 1];
        primes = new ArrayList<>();
    }

    public int getFirstValueWithOverFiveThousandWays() {
        calculatePrimes();
        for (int i = 2; i <= lim; i++) {
            if (sieve[i] == 0) {
                primes.add(i);
            }
        }

        //calculate all the primes till lim

        for (int i = 2; i <= lim; i++) {
            for (int j = 0; j < primes.size() && primes.get(j) <= i; j++) {
                int prime = primes.get(j);

                if (i == prime) {
                    dp[i][j] = 1 + ((j - 1) >= 0 ? dp[i][j - 1] : 0);
                } else {

                    int num = min(prime, i - prime);

                    int nearestPrimeIdx = getNearestPrimeIdx(num);
                    dp[i][j] = ((j - 1) >= 0 ? dp[i][j - 1] : 0) + ((nearestPrimeIdx != -1) ? dp[i
                        - prime][nearestPrimeIdx] : 0);

                    if (dp[i][j] >= 5000) {
                        int primeIdx = searchPrime(i);
                        if (primeIdx != -1) {
                            if (dp[i][j] - 1 >= 5000) {
                                return i;
                            }

                        } else {
                            return i;
                        }
                    }
                }

            }


        }

        return -1;


    }

    private void calculatePrimes() {
        for (int i = 2; i * i <= lim; i++) {
            for (int j = i * i; j <= lim; j += i) {
                sieve[j] = 1;
            }
        }
    }

    private int getNearestPrimeIdx(int num) {
        int u = 0;
        int v = primes.size() - 1;
        int ans = -1;

        while (u <= v) {
            int mid = (u + v) / 2;
            int midPrimeValue = primes.get(mid);

            if (midPrimeValue == num) {
                return mid;
            } else if (midPrimeValue > num) {
                v = mid - 1;
            } else {
                ans = mid;
                u = mid + 1;
            }

        }

        return ans;


    }

    private int searchPrime(int num) {
        int u = 0;
        int v = primes.size() - 1;

        while (u <= v) {
            int mid = (u + v) / 2;
            int midPrimeValue = primes.get(mid);

            if (midPrimeValue == num) {
                return mid;
            } else if (midPrimeValue > num) {
                v = mid - 1;
            } else {
                u = mid + 1;
            }

        }

        return -1;
    }

    private int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

}
