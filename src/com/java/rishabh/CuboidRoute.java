package com.java.rishabh;

public class CuboidRoute {

    CuboidRoute() {
    }

    public int getLeastValueOfM() {
        int cnt=1975;
        int lim=99;

        while(true) {

            lim++;

            for (int i = 2; i <= 2*lim; i++) { //(combination of (i+j)
                        if (isPerfectSquare(i*i+ lim*lim)) {

                            cnt+=(i<=lim?(i/2):i/2-(i-lim)+1);
                        }
            }

            if(cnt>1000000) {
                System.out.println(cnt);
                break;
            }

        }

        return lim;
    }

    private boolean isPerfectSquare(int num)
    {
        int x=(int)Math.sqrt(num);
        return x*x==num;
    }
}
