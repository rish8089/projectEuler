package com.java.rishabh;

public class ReciprocalCycles {

    public int denominatorWithLongestRepeatingCycle()
    {
        int longest_cycle=0;
        int longest_cycle_denominator=1;

        for(int i=2;i<1000;i++)
        {
            int retVal=lengthOfRepeatingCycle(i);

            if(longest_cycle<retVal) {
                longest_cycle = retVal;
                longest_cycle_denominator = i;
            }
        }
        return longest_cycle_denominator;
    }

    private int lengthOfRepeatingCycle(int d)
    {

        int n=1;//numerator
        int cycle_length=0;

        boolean visited[]=new boolean[1000];

        while(true)
        {
            int cnt=0;
            while((n/d)==0)
            {
                n=n*10;
                cnt+=1;
            }
            //cycle length encountered so far is cnt-1

            cycle_length+=cnt-1;

            n=n%d;

            if(n==0) //no cycle formed
                return 0;

            if(!visited[n]) {
                visited[n] = true;
                cycle_length += 1;
            }
            else
                break;
        }

        return cycle_length;
    }

}
