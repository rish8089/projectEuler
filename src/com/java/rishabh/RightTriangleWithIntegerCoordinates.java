package com.java.rishabh;

public class RightTriangleWithIntegerCoordinates {

    int lim=50;


    public int getNoOfRightTriangles()
    {

        int cnt=3*lim*lim;

        for(int x=1;x<=lim;x++)
        {
            for(int y=1;y<=lim;y++)
            {
                //(x,y) tuples
                //a<x, check for all a<x, which can give us some valid right triangle coordinates.
                for(int a=0;a<x;a++)
                {
                    if((x*x+y*y-a*x)%y==0)
                    {
                        int b=(x*x+y*y-a*x)/y;
                        if(b<=lim)
                            cnt+=1;
                    }
                }

                for(int b=0;b<y;b++)
                {
                    if((x*x+y*y-b*y)%x==0)
                    {
                        int a=(x*x+y*y-b*y)/x;
                        if(a<=lim)
                            cnt+=1;
                    }
                }
            }
        }

        return cnt;
    }

}
