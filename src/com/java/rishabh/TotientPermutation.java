package com.java.rishabh;

import java.util.ArrayList;
import java.util.List;

public class TotientPermutation {

    Fraction phi[];
    int lim = 10000000;

    TotientPermutation() {
        phi = new Fraction[lim];
        for (int i = 0; i < lim; i++) {
            phi[i] = new Fraction();
        }
    }

    public int getPermutedTotientWithMinimumValue() {
        calculateTotients();

        long num1, num2;
        int ans=-1;

        Fraction minTotient=new Fraction();
        minTotient.n=-1;
        minTotient.d=-1;
        for (int i = 2; i < lim; i++) {
            num1 = i;
            num2=1;
            if (phi[i].n == 0) {
                phi[i].n=i;
                phi[i].d=i-1;
            }


            num2 = ((num2 * i) * phi[i].d) / phi[i].n;

            if (isPermuatation(num1, num2)) {
                if(minTotient.n==-1 || (minTotient.n*phi[i].d>minTotient.d*phi[i].n))
                {
                    minTotient.n=phi[i].n;
                    minTotient.d=phi[i].d;
                    ans=i;

                }
            }
        }

        return ans;
    }

    private void calculateTotients() {

        int i, j;
        for (i = 2; i * i < lim; i++) {
            if (phi[i].n == 0) {
                for (j = i * i; j < lim; j += i) {
                    if (phi[j].n == 0) {
                        phi[j].n = i;
                        phi[j].d = (i - 1);
                    } else {
                        phi[j].n *= i;
                        phi[j].d *= (i - 1);
                    }

                }
            }
        }

        while (i < lim) {
            if (phi[i].n == 0) {
                j = 2 * i;
                while (j < lim) {
                    if (phi[j].n == 0) {
                        phi[j].n = i;
                        phi[j].d = (i - 1);
                    } else {
                        phi[j].n *= i;
                        phi[j].d *= (i - 1);
                    }

                    j += i;
                }
            }
            i++;
        }




    }

    private boolean isPermuatation(long num1, long num2) {
        List<Integer> digits = new ArrayList<>();
        while (num1 > 0) {
            digits.add((int) (num1 % 10));
            num1 /= 10;
        }

        while (num2 > 0) {
            int x = (int) (num2 % 10);
            if (digits.contains(x)) {
                digits.remove(new Integer(x));
            } else {
                return false;
            }
            num2 /= 10;
        }

        if (digits.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    class Fraction {

        long n;
        long d;

        public long getN() {
            return n;
        }

        public void setN(long n) {
            this.n = n;
        }

        public long getD() {
            return d;
        }

        public void setD(long d) {
            this.d = d;
        }
    }

}
