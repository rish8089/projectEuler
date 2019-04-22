package com.java.rishabh;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class DiophantineEquation {

    int Dlim = 1000;
    List<Integer> partials;

    DiophantineEquation() {
        partials=new ArrayList<>();
    }

    public long getMaximalX() {

        int x;
        BigInteger ans=BigInteger.ZERO;
        int D=-1;
        for (int i = 1; i <=1000 ; i++) {
            if (!isPerfectSquare(i)) {
                partials.clear();
                x = (int) Math.sqrt(i);
                if (x * x - i == 1) {
                    if (ans.compareTo(BigInteger.valueOf(x))<0) {
                        System.out.println("i = " +i+",x = "+x);
                        ans=BigInteger.valueOf(x);
                        D=i;
                    }
                    break;
                }

                partials.add(x);
                int p = 0;
                int q = 1;

                while (true) {
                    p = partials.get(partials.size() - 1) * q - p;
                    q = (i - p * p) / q;

                    partials.add((int) Math.floor((Math.sqrt(i)+ p) / q));

                    //added one more partial , its time to calculate another fraction.
                    Fraction ret=recurse(0);
                    if((ret.a.multiply(ret.a)).subtract(BigInteger.valueOf(i).multiply(ret.b).multiply(ret.b)).equals(BigInteger.ONE))
                    {
                        System.out.println("i = " +i+",x = "+ret.a);
                        if(ans.compareTo(ret.a)<0) {
                            ans = ret.a;
                            D=i;
                        }
                        break;
                    }
                }


            }
        }

        return D;

    }

    private Fraction recurse(int i)
    {

        if(i+1==partials.size())
            return new Fraction(BigInteger.valueOf(partials.get(i)),BigInteger.ONE);

        Fraction ret=recurse(i+1);
        /*long tempNumerator=ret.a;
        ret.a=partials.get(i)*ret.a+ret.b;
        ret.b=tempNumerator;*/
        return new Fraction(BigInteger.valueOf(partials.get(i)).multiply(ret.a).add(ret.b),ret.a);

    }

    private boolean isPerfectSquare(long num) {
        int x = (int) Math.sqrt(num);
        return x * x == num;
    }

    class Fraction
    {
        BigInteger a;
        BigInteger b;

        public Fraction(BigInteger a, BigInteger b) {
            this.a = a;
            this.b = b;
        }
    }

}
