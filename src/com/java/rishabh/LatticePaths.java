package com.java.rishabh;

import java.math.BigInteger;

public class LatticePaths {

    int lim=40;

    public BigInteger getTotalNumberOfPath()
    {
        BigInteger prod1=BigInteger.ONE;
        BigInteger prod2=BigInteger.ONE;

        for(int i=40;i>=21;i--)
            prod1=prod1.multiply(BigInteger.valueOf(i));

        System.out.println(prod1);

        for(int i=1;i<=20;i++)
            prod2=prod2.multiply(BigInteger.valueOf(i));

        return prod1.divide(prod2);

    }

}
