package com.java.rishabh;

import java.io.BufferedReader;
import java.io.IOException;

public class LargestProductInAgrid {

    int A[][];
    int lim=20;
    BufferedReader br;

    LargestProductInAgrid(BufferedReader br)
    {
        this.br=br;
        A=new int[lim][lim];
    }

    public void processInput() throws IOException {
        for(int i=0;i<lim;i++)
        {
            String str[]=br.readLine().split(" ");
            for(int j=0;j<str.length;j++)
                A[i][j]=Integer.parseInt(str[j]);
        }
    }

    public int getLargestProductInGrid()
    {
        int ans=0;


        //16,17,18,19, 19-3,19,17,18,16
        for(int i=0;i<lim;i++)
        {
            for(int j=0;j<lim;j++)
            {
                //right
                if(j+3<lim)
                {
                    if(ans<A[i][j]*A[i][j+1]*A[i][j+2]*A[i][j+3])
                    {
                        ans=A[i][j]*A[i][j+1]*A[i][j+2]*A[i][j+3];
                    }
                }

                //left
                if(j-3>=0)
                {
                    if(ans<A[i][j]*A[i][j-1]*A[i][j-2]*A[i][j-3])
                    {
                        ans=A[i][j]*A[i][j-1]*A[i][j-2]*A[i][j-3];
                    }
                }

                //down
                if(i+3<lim)
                {
                    if(ans<A[i][j]*A[i+1][j]*A[i+2][j]*A[i+3][j])
                    {
                        ans=A[i][j]*A[i+1][j]*A[i+2][j]*A[i+3][j];
                    }
                }

                if(i-3>=0)
                {
                    if(ans<A[i][j]*A[i-1][j]*A[i-2][j]*A[i-3][j])
                    {
                        ans=A[i][j]*A[i+1][j]*A[i+2][j]*A[i+3][j];
                    }
                }

                if((i+3)<lim && (j+3)<lim)
                {
                    if(ans<A[i][j]*A[i+1][j+1]*A[i+2][j+2]*A[i+3][j+3])
                    {
                        ans=A[i][j]*A[i+1][j+1]*A[i+2][j+2]*A[i+3][j+3];
                    }
                }

                if((i+3)<lim && (j-3)>=0)
                {
                    if(ans<A[i][j]*A[i+1][j-1]*A[i+2][j-2]*A[i+3][j-3])
                    {
                        ans=A[i][j]*A[i+1][j-1]*A[i+2][j-2]*A[i+3][j-3];
                    }


                }

                if((i-3)>=0 && (j+3)<lim)
                {
                    if(ans<A[i][j]*A[i-1][j+1]*A[i-2][j+2]*A[i-3][j+3])
                    {
                        ans=A[i][j]*A[i-1][j+1]*A[i-2][j+2]*A[i-3][j+3];
                    }
                }

                if((i-3)>=0 && (j-3)>=0)
                {
                    if(ans<A[i][j]*A[i-1][j-1]*A[i-2][j-2]*A[i-3][j-3])
                    {
                        ans=A[i][j]*A[i-1][j-1]*A[i-2][j-2]*A[i-3][j-3];
                    }
                }
            }
        }

        return ans;
    }

}
