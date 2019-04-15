package com.java.rishabh;

import java.util.ArrayList;
import java.util.List;

public class PrimePairSets {

    int primeLim = 10000000;
    int lim = 10000;
    boolean sieve[];
    List<Integer> primes;
    private int res[];

    PrimePairSets() {
        sieve = new boolean[primeLim + 1];
        primes = new ArrayList<>();
        res = new int[10];
    }

    public int getLowestSumForSetOfFivePrimes() {
        calculatePrimes();
        for (int i = 2; i <= lim; i++) {
            if (!sieve[i]) {
                primes.add(i);
            }
        }

        for (int i = 0; i <= primes.size() - 5; i++) {
            res[0] = primes.get(i);
            if(recurse(i, 1)) {
                System.out.println("got the combination");
                break;
            }
        }

        int sum=0;

        for (int element : res) {
           sum=sum+element;
            System.out.println(element);
        }


        return sum;
    }

    private boolean recurse(int idx, int cnt) {

        for (int i = idx + 1; i <=primes.size()-4-cnt; i++) {

            int prime=primes.get(i);
            boolean flag=true;
            for (int j = 0; j < cnt; j++) {
                if(!isConcatenationPrime(res[j],prime))
                {
                    flag=false;
                    break;
                }
            }

            if(flag)
            {
                res[cnt]=prime;
                if(cnt==4)
                    return true;
                else
                {
                    boolean ret=recurse(i,cnt+1);
                    if(ret)
                        return true;
                }
            }

        }

        return false;
    }

    private void calculatePrimes() {
        for (int i = 2; i * i <= primeLim; i++) {
            if (!sieve[i]) {
                for (int j = i * i; j <= primeLim; j += i) {
                    sieve[j] = true;
                }
            }
        }
    }

    private boolean isConcatenationPrime(int num1, int num2) {
        boolean ans = true;
        int d2 = getNoOfDigits(num2);
        long val = num1 * ((long) Math.pow(10, d2)) + num2;
        if (val <= primeLim) {
            ans = ans && !sieve[(int) val];
        } else {
            ans = ans && isPrime(val);
        }

        int d1 = getNoOfDigits(num1);
        val = num2 * ((long) Math.pow(10, d1)) + num1;
        if (val <= primeLim) {
            ans = ans && !sieve[(int) val];
        } else {
            ans = ans && isPrime(val);
        }

        return ans;

    }

    private int getNoOfDigits(int num) {
        int d = 0;
        while (num > 0) {
            d = d + 1;
            num = num / 10;
        }
        return d;
    }

    private boolean isPrime(long num) {
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


}
