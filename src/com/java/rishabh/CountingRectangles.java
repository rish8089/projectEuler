package com.java.rishabh;

public class CountingRectangles {

    int lim=2000000;

    public long getNearestArea()
    {
        long N,min=-1,expressionVal,nearestArea=0;
        for(int i=1;i<lim;i++) //as M and N are symmetrical
        {
            //consider i as M
            long val=i*i+i;
            N=(-val+getSquareRoot(val*val+lim*16*val))/(2*val);
            if(N>=1) {

                expressionVal = evaluateExpression(i, N);

                if (min == -1 || min > expressionVal) {
                    min = expressionVal;
                    nearestArea = i * N;
                }
            }
            else
                break;


        }

        System.out.println(min);
        return nearestArea;
    }

    private int getSquareRoot(long num)
    {
        return (int)Math.sqrt(num);
    }

    private long evaluateExpression(long M,long N)
    {
        long val=M*M+M;
        return 4*lim-N*N*val-N*val;
    }

}
