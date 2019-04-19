package com.java.rishabh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CubePermutations {

    long lim=9000;

    public long getSmallestCubeWithFiveCubicPermutations()
    {
        List<Long> cubes=new ArrayList<>();

        long i=2,ans=-1;
        while(i<lim)
        {
            cubes.add(i*i*i);
            i++;
        }

        HashSet<Long> hashSet=new HashSet<>();
        for(int j=0;j<cubes.size();j++)
        {
            if(!hashSet.contains(cubes.get(j))) {
                int cnt=0;
                for (int k = 0; k < cubes.size(); k++) {
                    if(isPermutation(cubes.get(j),cubes.get(k)))
                    {
                        hashSet.add(cubes.get(k));
                        cnt+=1;
                    }
                }

                if(cnt==5)
                {
                    ans=cubes.get(j);
                    break;
                }
            }
        }

        return ans;
    }

    private boolean isPermutation(long a,long b)
    {
        int hash[]=new int[10];

        while(a>0)
        {
            hash[(int)(a%10)]++;
            a=a/10;
        }

        while(b>0)
        {
            hash[(int)(b%10)]--;
            b=b/10;
        }

        for(int i=0;i<=9;i++)
        {
            if(hash[i]!=0)
                return false;

        }
        return true;
    }
}
