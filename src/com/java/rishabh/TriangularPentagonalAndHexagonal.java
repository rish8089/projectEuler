package com.java.rishabh;

public class TriangularPentagonalAndHexagonal {

    long previousTriangleNoIdx=285;

    public long getNextTriangleNo()
    {
        long nextTriangleNoIdx=previousTriangleNoIdx+1;

        while(true)
        {
            long pentagonalNumberIdx=getPentagonalNumberIdx(getTriangleNo(nextTriangleNoIdx));
            long hexagonalNumberIdx=getHexagonalNumberIdx(getTriangleNo(nextTriangleNoIdx));

            if(pentagonalNumberIdx!=-1 && hexagonalNumberIdx!=-1) {
                System.out.println("triangleNoIdx = "+nextTriangleNoIdx);
                return getTriangleNo(nextTriangleNoIdx);
            }

            nextTriangleNoIdx++;
        }
    }

    private long getPentagonalNumberIdx(long triangleNo)
    {
        long squareRoot=getSquareRoot(1+24*triangleNo);

        if(squareRoot!=-1)
        {
            if((squareRoot+1)%6==0)
                return (squareRoot+1)/6;
        }

        return -1;
    }

    private long getHexagonalNumberIdx(long triangleNo)
    {
        long squareRoot=getSquareRoot(1+8*triangleNo);
        if(squareRoot!=-1)
        {
            if((squareRoot+1)%4==0)
                return (squareRoot+1)/4;
        }
        return -1;
    }

    private long getSquareRoot(long num)
    {
        long squareRoot=(long)Math.sqrt(num);

        if(squareRoot*squareRoot==num)
            return squareRoot;
        else
            return -1;
    }

    private long getTriangleNo(long triangleNoIdx)
    {
        return triangleNoIdx*(triangleNoIdx+1)/2;
    }

}
