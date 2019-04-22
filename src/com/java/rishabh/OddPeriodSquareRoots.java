package com.java.rishabh;

public class OddPeriodSquareRoots {

    int lim = 10000;

    public int getNoOfContinuedFractionsWithOddPeriod() {

        int ans=0;

        for (int i = 2; i <= lim; i++) {

            if(!isPerfectSquare(i)) {

                FractionPart denominator = new FractionPart();
                denominator.a = i;
                denominator.b = -(int) Math.sqrt(i);
                FractionPart numerator = new FractionPart();
                numerator.a = 0;
                numerator.b = 1;

                int cnt = 0;
                while (true) {

                    int temp = denominator.b;
                    denominator.b = denominator.a - (denominator.b) * (denominator.b);
                    int commonFactor = gcd(numerator.b, denominator.b);
                    numerator.b = numerator.b / commonFactor;
                    denominator.b = denominator.b / commonFactor;
                    numerator.a = numerator.b * numerator.b * denominator.a;
                    numerator.b = -temp * numerator.b;
                    denominator.a = 0;

                    cnt += 1;

                    if (denominator.b == 1)
                        break;

                    int nextInt = ((int) Math.sqrt(numerator.a) + numerator.b) / denominator.b;
                    numerator.b = numerator.b - denominator.b * nextInt;

                    swap(numerator, denominator);
                }

                if (cnt % 2 != 0)
                    ans += 1;
            }

        }

        return ans;

    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    private void swap(FractionPart numerator, FractionPart denominator) {
        FractionPart temp = new FractionPart();
        temp.a = numerator.a;
        temp.b = numerator.b;

        numerator.a = denominator.a;
        numerator.b = denominator.b;

        denominator.a = temp.a;
        denominator.b = temp.b;
    }

    class FractionPart {

        int a;//if this is set , it means a  is square root
        int b;

        FractionPart() {
            a = 0;
        }

    }

    private boolean isPerfectSquare(int num)
    {
        int x=(int)Math.sqrt(num);
        return x*x==num;
    }

}
