package com.java.rishabh;

import java.io.BufferedReader;
import java.io.IOException;

public class CodedTriangleNumbers {

    private BufferedReader br;
    private String words[];

    CodedTriangleNumbers(BufferedReader br)
    {
        this.br=br;
    }

    public void processInput() throws IOException {
        words=br.readLine().split(",");
    }

    public int getCountOfCodedTriangleNumbers()
    {
        int cnt=0,alphabeticalVal;
        for(String word:words)
        {
            alphabeticalVal=0;
            for(int i=1;i<word.length()-1;i++)
            {
                alphabeticalVal+=word.charAt(i)-64;
            }

            int squareRoot=getSquareRoot(1+8*alphabeticalVal);
            if(squareRoot!=-1)
            {
                if((squareRoot-1)%2==0) {
                    System.out.println("alphabeticalVal = " + alphabeticalVal);
                    cnt += 1;
                }
            }
        }
        return cnt;
    }

    private int getSquareRoot(int num)
    {
        int squareRoot=(int)Math.sqrt(num);
        if(squareRoot*squareRoot==num)
            return squareRoot;
        else
            return -1;

    }

}
