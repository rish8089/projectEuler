package com.java.rishabh;

//reference
//https://www.wolframalpha.com/input/?i=2*b*b-2b+%3D+n*n-n

import com.java.rishabh.DiophantineEquation.Fraction;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ArrangedProbability {


    long lim=1000000000000l;
    List<Integer> partials;

    ArrangedProbability()
    {
        partials=new ArrayList<>();
    }

    public long getSolution()
    {
        int D=2;
        int x = (int) Math.sqrt(D);

        partials.add(x);

        int p = 0;
        int q = 1;

        while (true) {
            p = partials.get(partials.size() - 1) * q - p;
            q = (D - p * p) / q;
            partials.add((int) Math.floor((x+ p) / q));

            Fraction ret=recurse(0);

            if(ret.a%2!=0 && ret.b%2!=0)
            {
                BigInteger val1=BigInteger.valueOf(ret.b).multiply(BigInteger.valueOf(ret.b)).multiply(BigInteger.valueOf(2));
                BigInteger val2=BigInteger.valueOf(ret.a).multiply(BigInteger.valueOf(ret.a));
                if((val1.subtract(val2)).equals(BigInteger.ONE))
                {
                    if((ret.a+1)/2>=lim)
                    {
                        return (ret.b+1)/2;
                    }
                }
            }

        }

    }

    private Fraction recurse(int i)
    {

        if(i+1==partials.size())
            return new Fraction(partials.get(i),1);

        Fraction ret=recurse(i+1);
        return new Fraction(partials.get(i)*ret.a+ret.b,ret.a);

    }

    class Fraction
    {
        long a;
        long b;

        public Fraction(long a, long b) {
            this.a = a;
            this.b = b;
        }
    }


}
