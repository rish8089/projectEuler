package com.java.rishabh;

public class IntegerRightTriangles {

    public int getPerimeterValueWithMaxSolutions()
    {
        int maxCnt=0;
        int ans=0;
        for(int i=1;i<=1000;i++)
        {
            int cnt=0;
            boolean flag=true;

            for(int j=1;j<=i/2;j++)
            {
                for(int k=1;k<=i/2;k++)
                {
                    if(i<j+k)
                    {
                        flag=false;
                        break;
                    }

                    int l=i-j-k;
                    if(j*j+k*k==l*l)
                    {
                        cnt+=1;
                    }
                }
                if(!flag)
                    break;
            }

            if(maxCnt<cnt)
            {
                maxCnt=cnt;
                ans=i;
            }
        }

        return ans;
    }

}
