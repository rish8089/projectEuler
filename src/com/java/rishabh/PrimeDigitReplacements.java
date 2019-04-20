package com.java.rishabh;

import java.util.ArrayList;
import java.util.List;

public class PrimeDigitReplacements {

    int lim = 10000000;
    boolean sieve[];

    PrimeDigitReplacements() {
        sieve = new boolean[lim + 1];
    }

    public int getSmallestPrime() {
        calculatePrimes();

        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= lim; i++) {
            if (!sieve[i]) {
                primes.add(i);
            }
        }

        int ans = 0;

        for (int i = 0; i < primes.size(); i++) {
            int prime = primes.get(i);
            List<Integer> digits = getNoOfDigits(prime);

            List<String> binaries = getBinaries(digits.size());
            for (String binary : binaries) {
                int cnt = 0;
                int  j;

                if(binary.length()==digits.size())
                    j=0;
                else
                    j=1;
                while(j <= 9)  {
                    //j is replacing digit
                    int s = 0;
                    int k = 0;

                    while (k < (digits.size() - binary.length())) {
                        s = s * 10 + j;
                        k++;
                    }

                    int digitIdx = k;
                    k = 0;
                    while (k < binary.length()) {
                        if (binary.charAt(k) == '1') {
                            s = s * 10 + digits.get(digits.size() - digitIdx - 1);
                        } else {
                            s = s * 10 + j;
                        }
                        k++;
                        digitIdx++;

                    }


                    if (isPrime(s)) {
                        cnt += 1;
                    }
                    j++;

                    /*if(9-j+1<(8-cnt))
                        break;*/
                }

                if (cnt == 8) {
                    ans = prime;
                    System.out.println(binary);
                    break;
                }


            }

            if (ans > 0) {
                break;
            }
        }
        return ans;

    }

    private void calculatePrimes() {

        sieve[0] = true;
        sieve[1] = true;
        for (int i = 2; i * i <= lim; i++) {
            if (!sieve[i]) {
                for (int j = i * i; j <= lim; j += i) {
                    sieve[j] = true;
                }
            }
        }

    }

    private List<Integer> getNoOfDigits(int num) {
        List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add(num % 10);
            num = num / 10;
        }

        return digits;
    }

    private List<String> getBinaries(int noOfDigits) {
        List<String> binaries = new ArrayList<>();

        int maxNum = (1 << noOfDigits) - 1;
        int i = 1;

        while (i < maxNum) {
            binaries.add(Integer.toBinaryString(i));
            i++;
        }

        return binaries;


    }


    private boolean isPrime(int num) {

        if (num == 1) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }


}
