package com.java.rishabh;

import java.io.BufferedReader;
import java.io.IOException;

public class LargestProductInASeries {

    int A[];
    BufferedReader br;
    int lim=1000;

    LargestProductInASeries(BufferedReader br)
    {
        this.br=br;
        A=new int[lim];
    }

    public void processInput() throws IOException {
        int idx=0;
        for(int i=0;i<20;i++)
        {
            String str=br.readLine();
            for(int j=0;j<str.length();j++)
                A[idx++]=str.charAt(j)-'0';
        }
    }

    public long getLargestProduct()
    {
        long ans=0;
        for(int i=0;i<=lim-13;i++)
        {
            long prod=1;
            for(int j=i;j<i+13;j++)
            {
                prod=prod*A[j];
            }

            if(ans<prod)
                ans=prod;

        }

        return ans;
    }


}
