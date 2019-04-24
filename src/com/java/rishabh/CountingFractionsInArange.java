package com.java.rishabh;

import java.util.HashSet;
import java.util.Objects;

public class CountingFractionsInArange {

    int lim = 12000;
    private HashSet<Fraction> hashSet;

    CountingFractionsInArange() {
        hashSet = new HashSet<>();
    }

    public int getNoOfFractionsBetween1By3And1By2() {
        int p1, p2, q, ans = 0, cnt;

        for (int i = 2; i <= lim; i++) {
            q = i;
            cnt = 0;

            if (q % 2 != 0) {
                p1 = q / 2;
            } else {
                p1 = q / 2 - 1;
            }

            if (p1 != 0) {
                //we have some fractions less than 1/2 for denominator=q
                p2 = q / 3 + 1;

                if (p2 != 0 && p2 <= p1) {
                    cnt = p1 - p2 + 1;

                    //some repeated fractions should be removed.

                    HashSet<Integer> hashSet=new HashSet<>();

                    for (int j = 2; j * j <= q && j <= p1; j++) {
                        if (q % j == 0) {
                            if (q / j != j) {

                                populateMultiplesInTheRangeP1ToP2(j,p2,p1,hashSet);
                                populateMultiplesInTheRangeP1ToP2(q/j,p2,p1,hashSet);
                            }
                            else
                            {
                                //both the factors are
                                populateMultiplesInTheRangeP1ToP2(j,p2,p1,hashSet);

                            }
                        }
                    }

                    cnt-=hashSet.size();
                }


            }

            ans += cnt;
        }

        return ans;
    }


    private void populateMultiplesInTheRangeP1ToP2(int j, int p2, int p1,
        HashSet<Integer> hashSet) {
        int startMultiple;

        if (j <=p2) {
            startMultiple = ((int) Math.ceil(p2*1.0 / j)) * j;

        } else {
            startMultiple = j;
        }

        for (int i = startMultiple; i <= p1; i += j) {
            hashSet.add(i);
        }


    }


    class Fraction {

        int a;
        int b;

        public Fraction(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Fraction fraction = (Fraction) o;
            return a == fraction.a &&
                b == fraction.b;
        }

        @Override
        public int hashCode() {

            return Objects.hash(a, b);
        }
    }

}
