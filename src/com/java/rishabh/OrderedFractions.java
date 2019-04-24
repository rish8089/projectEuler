package com.java.rishabh;

public class OrderedFractions {

    int lim = 1000000;

    public String getFractionJustPrevTo3By7() {

        Fraction ans = new Fraction(0, 1);
        int p,q;

        for (int i = 2; i <= lim; i++) {
            //find out the candidate p
            q=i;

            if ((q * 3) % 7 != 0) {
                p = q * 3 / 7;
            } else {
                p = q * 3 / 7 - 1;
            }

            //our candidate fraction less than 3/7 is p/q
            //if our ans fraction is less than candidate fraction ,then its  good
            int commonFactor=gcd(p,q);
            p=p/commonFactor;
            q=q/commonFactor;

            //we got p/q

            if(ans.b*p-ans.a*q>0)
            {
                ans.a=p;
                ans.b=q;
            }
        }

        return ans.a+"/"+ans.b;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    class Fraction {

        int a;
        int b;

        public Fraction(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

}
