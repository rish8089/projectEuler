package com.java.rishabh;

import java.io.BufferedReader;
import java.io.IOException;

public class PathSumFourWays {

    int lim=80;
    int A[][];
    int[] M={-1,0,0,1};
    int[] N={0,1,-1,0};
    private BufferedReader br;
    private boolean visited[][];
    private int minimalSum[][];

    PathSumFourWays(BufferedReader br){
        this.br=br;
        A=new int[lim][lim];
        visited=new boolean[lim][lim];
        minimalSum=new int[lim][lim];
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
        visited[0][0]=true;
        minimalSum[0][0]=A[0][0];
        dfs(0,0);
        return minimalSum[lim-1][lim-1];
    }

    private void dfs(int i,int j)
    {
        for(int k=0;k<4;k++)
        {
            int x=i+M[k];
            int y=j+N[k];
            if(x<lim && y<lim && x>=0 && y>=0)
            {
                if(!visited[x][y]) {

                    if(minimalSum[x][y]==0 || minimalSum[x][y]>minimalSum[i][j]+A[x][y]) {
                        visited[x][y] = true;
                        minimalSum[x][y]=minimalSum[i][j]+A[x][y];
                        dfs(x, y);
                        visited[x][y] = false;
                    }
                }
            }
        }
    }



}
