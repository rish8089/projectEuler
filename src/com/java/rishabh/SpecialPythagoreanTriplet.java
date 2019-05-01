package com.java.rishabh;

public class SpecialPythagoreanTriplet {

    int lim=1000;

    public int getProductOfABC()
    {
        for(int m=2;m*m<lim;m++)
        {
            for(int n=1;n<m;n++)
            {
                int a=m*m-n*n;
                int b=2*m*n;
                int c=m*m+n*n;
                if(a+b+c==1000)
                    return a*b*c;
            }
        }

        return 0;
    }

}
