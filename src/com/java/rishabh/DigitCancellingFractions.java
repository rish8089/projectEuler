package com.java.rishabh;

import java.util.ArrayList;
import java.util.List;

public class DigitCancellingFractions {

    public int getDenominatorOfProductOfFourNonTrivialFractions()
    {
        int num1FirstDigit,num1SecondDigit,num2FirstDigit,num2SecondDigit;

        List<Fraction> non_trivial_fractions=new ArrayList<>();

        for(int i=10;i<=99;i++)
        {
            for(int j=10;j<=99;j++)
            {

                if(i<j) {
                    boolean flag = false;

                    num1SecondDigit = i % 10;
                    num1FirstDigit = (i / 10) % 10;
                    num2SecondDigit = j % 10;
                    num2FirstDigit = (j / 10) % 10;

                    if (num1SecondDigit != 0 || num2SecondDigit != 0) {
                        int divisor = gcd(i, j);
                        int reducedNumerator = i / divisor;
                        int reducedDenominator = j / divisor;

                        if (num1FirstDigit == num2SecondDigit && !flag) {
                            divisor = gcd(num1SecondDigit, num2FirstDigit);
                            if (num1SecondDigit / divisor == reducedNumerator
                                && num2FirstDigit / divisor == reducedDenominator) {
                                //push to non_trivial_functions
                                non_trivial_fractions.add(new Fraction(i, j));
                                flag = true;
                            }

                        }

                        if (num1SecondDigit == num2FirstDigit && num2SecondDigit != 0 && !flag) {
                            divisor = gcd(num1FirstDigit, num2SecondDigit);
                            if (num1FirstDigit / divisor == reducedNumerator
                                && num2SecondDigit / divisor == reducedDenominator) {
                                //push to non_trivial_functions
                                non_trivial_fractions.add(new Fraction(i, j));
                                flag = true;
                            }
                        }

                        if (num1FirstDigit == num2FirstDigit && num2SecondDigit != 0 && !flag) {
                            divisor = gcd(num1SecondDigit, num2SecondDigit);

                            if (num1SecondDigit / divisor == reducedNumerator
                                && num2SecondDigit / divisor == reducedDenominator) {
                                non_trivial_fractions.add(new Fraction(i, j));
                                flag = true;
                            }
                        }

                        if (num1SecondDigit == num2SecondDigit && !flag) {
                            divisor = gcd(num1FirstDigit, num2FirstDigit);

                            if (num1FirstDigit / divisor == reducedNumerator
                                && num2FirstDigit / divisor == reducedDenominator) {
                                non_trivial_fractions.add(new Fraction(i, j));
                                flag = true;
                            }
                        }

                    }
                }

            }
        }

        int productOfNumerators=1;
        int productOfDenominator=1;

        for(Fraction fraction:non_trivial_fractions)
        {
            System.out.println("fraction = " + fraction.getNumerator()+"/"+fraction.getDenominator());
            productOfNumerators*=fraction.getNumerator();
            productOfDenominator*=fraction.getDenominator();
        }

        return productOfDenominator/gcd(productOfNumerators,productOfDenominator);
    }

    private int gcd(int a,int b)
    {
        if(b==0)
            return a;
        else
            return gcd(b,a%b);
    }

    class Fraction
    {
        int numerator;
        int denominator;

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public int getNumerator() {
            return numerator;
        }

        public void setNumerator(int numerator) {
            this.numerator = numerator;
        }

        public int getDenominator() {
            return denominator;
        }

        public void setDenominator(int denominator) {
            this.denominator = denominator;
        }
    }



}

