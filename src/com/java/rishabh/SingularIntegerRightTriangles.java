package com.java.rishabh;

public class SingularIntegerRightTriangles {

    int L=10000;

    public int getNoOfSingularIntegerRightTriangles()
    {
        int cnt=0;
        for(int l=12;l<=L;l++)
        {
            boolean flag=false;
            int x=L%3;
            for(int k=L/3+((x==0)?1:x);k<L/2;k++)
            {
                for(int j=L/3;j+k>L/2;j--)
                {
                    int i=l-k-j;
                    if(i*i+j*j==k*k)
                    {
                        flag=true;
                        break;
                    }
                }

                if(flag)
                    break;
            }

            if(flag)
                cnt+=1;
        }

        return cnt;

    }
}
