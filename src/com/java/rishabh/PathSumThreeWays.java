package com.java.rishabh;

import java.io.BufferedReader;
import java.io.IOException;

public class PathSumThreeWays {

    private int A[][];
    private int lim=80;
    private BufferedReader br;
    private boolean visited[][];
    private int minimalSum[][];

    PathSumThreeWays(BufferedReader br)
    {
        A=new int[lim][lim];
        visited=new boolean[lim][lim];
        minimalSum=new int[lim][lim];
        this.br=br;
    }

    public void processInput() throws IOException {
        for(int i=0;i<lim;i++)
        {
            String str[]=br.readLine().split(",");
            for(int j=0;j<lim;j++)
                A[i][j]=Integer.parseInt(str[j]);
        }
    }

    public int getMinimalSum()
    {
        for(int i=0;i<lim;i++)
        {
            visited[i][0]=true;
            minimalSum[i][0]=A[i][0];
            dfs(i,0);
        }

        int min=-1;

        for(int i=0;i<lim;i++)
        {
            if(min==-1)
                min=minimalSum[i][lim-1];
            else if(min>minimalSum[i][lim-1])
                min=minimalSum[i][lim-1];
        }

        return min;



    }

    private void dfs(int i,int j)
    {
        if(j!=0) //not the first column
        {
            if(i+1<lim) //going down
            {
                if(!visited[i+1][j])
                {
                    if(minimalSum[i+1][j]==0 || minimalSum[i+1][j]>minimalSum[i][j]+A[i+1][j]) {
                        visited[i+1][j]=true;
                        minimalSum[i + 1][j] = minimalSum[i][j] + A[i + 1][j];
                        dfs(i+1,j);
                        visited[i+1][j]=false;
                    }

                }
            }

            if(i-1>=0)
            {
                if(!visited[i-1][j])
                {
                    if(minimalSum[i-1][j]==0 || minimalSum[i-1][j]>minimalSum[i][j]+A[i-1][j]) {
                        visited[i-1][j]=true;
                        minimalSum[i -1][j] = minimalSum[i][j] + A[i -1][j];
                        dfs(i-1,j);
                        visited[i-1][j]=false;
                    }
                }
            }
        }

        //for any type of column ,we can go right
        if(j+1<lim)
        {
            if(!visited[i][j+1])
            {
                if(minimalSum[i][j+1]==0 || minimalSum[i][j+1]>minimalSum[i][j]+A[i][j+1])
                {
                    visited[i][j+1]=true;
                    minimalSum[i][j+1]=minimalSum[i][j]+A[i][j+1];
                    dfs(i,j+1);
                    visited[i][j+1]=false;
                }
            }
        }



    }


}
