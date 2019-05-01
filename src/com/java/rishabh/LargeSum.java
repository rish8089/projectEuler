package com.java.rishabh;

import java.io.BufferedReader;
import java.io.IOException;

public class LargeSum {

    BufferedReader br;
    int lim=50;
    int A[][];
    int res[];

    LargeSum(BufferedReader br)
    {
        this.br=br;
        A=new int[2*lim][lim];
        res=new int[3*lim];
    }

    public void processInput() throws IOException {
        for(int i=0;i<2*lim;i++)
        {
            String str=br.readLine();
            for(int j=0;j<str.length();j++)
                A[i][j]=str.charAt(j)-'0';
        }
    }

    public String getLargeSum()
    {
        for(int i=0;i<2*lim;i++)
        {
            int idx=3*lim-1;
            int carry=0;
            for(int j=lim-1;j>=0;j--)
            {
                int sum=carry+res[idx]+A[i][j];
                res[idx]=sum%10;
                carry=sum/10;
                idx--;
            }

            while(carry>0)
            {
                int sum=carry+res[idx];
                res[idx]=sum%10;
                carry=sum/10;
                idx--;
            }
        }

        String ans="";
        int idx=0;
        while(res[idx]==0)
            idx++;

        for(int i=idx;i<idx+10;i++)
        {
            ans=ans+res[i];
        }

        return ans;
    }

}
