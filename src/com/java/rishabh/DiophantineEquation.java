package com.java.rishabh;

public class DiophantineEquation {

    int lim=1000;

    public long getMaximalX()
    {
        long max=0,ans=-1;
        for(int i=lim;i<=lim;i++)
        {
            long y=1;
            long val=isPerfectSquare(i);
            if(val==-1) {
                while (true) {

                    val=isPerfectSquare(1 + i * y * y);
                    if(val!=-1)
                    {
                        if(max<val) {
                            max = val;
                            ans=i;
                        }
                        break;
                    }

                    y++;
                }
            }
        }

        System.out.println("max = " + max);
        return ans;
    }

    private long isPerfectSquare(long num)
    {
        long x=(long)Math.sqrt(num);
        if(x*x==num)
            return x;
        else
            return -1;
    }

}
