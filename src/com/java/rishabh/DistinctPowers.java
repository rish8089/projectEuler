package com.java.rishabh;

import java.util.HashSet;

public class DistinctPowers {

    int a=100;
    int b=100;

    public int getDistinctTerms()
    {
        boolean visited[]=new boolean[a+1];

        int ans=0;

        for(int i=2;i<=a;i++)
        {
            if(!visited[i])
            {
                int cnt=1;
                int num=i;

                HashSet<Integer> hashSet=new HashSet<>();

                while(num<=a)
                {
                    for(int j=2;j<=b;j++) {
                        hashSet.add(cnt*j);
                    }
                    visited[num]=true;
                    num=num*i;
                    cnt+=1;
                }

                ans+=hashSet.size();
            }
        }

        return ans;



    }

}
