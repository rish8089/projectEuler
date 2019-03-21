package com.java.rishabh;

public class PandigitalPrime {

    public int getLargestPandigitalPrime()
    {
        int ans=0;

        boolean visited[]=new boolean[10];

        for(int i=1;i<=9;i++)
        {
            //get all the combinations from 1 to i, and check if its prime
            int retVal=constructCombinations(i,visited,0);
            if(ans<retVal)
                ans=retVal;
        }
        return ans;
    }

    //construct combinations for range 1 to num
    private int constructCombinations(int num,boolean visited[],int combination)
    {

        boolean flag=false;
        int ans=0;

        for(int i=1;i<=num;i++)
        {
            if(!visited[i])
            {
                visited[i]=true;
                int retVal=constructCombinations(num,visited,combination*10+i);
                if(ans<retVal)
                    ans=retVal;
                flag=true;
                visited[i]=false;
            }
        }

        if(!flag)
        {
            if(isPrime(combination))
                ans=combination;
        }

        return ans;

    }


    boolean isPrime(int num)
    {

        if(num==1)
            return false;

        for(int i=2;i*i<=num;i++)
        {
            if(num%i==0)
            {
                return false;
            }
        }

        return true;
    }
}
