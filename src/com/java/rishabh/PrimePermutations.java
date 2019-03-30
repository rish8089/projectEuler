package com.java.rishabh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PrimePermutations {

    public String getPrimePermutations()
    {
        String ans="";
        for(int i=1000;i<=9999;i++)
        {
            if(isPrime(i))
            {
                List<Integer> permutations=getPermutations(i);

                for(int j=0;j<permutations.size();j++)
                {
                    if(permutations.get(j)>i) {
                        int diff = permutations.get(j) - i;
                        if (permutations.contains(permutations.get(j)+diff)) {

                            if (isPrime(permutations.get(j)) && isPrime(
                                permutations.get(j) + diff)) {
                                ans = "";
                                ans = ans.concat(String.valueOf(i));
                                ans = ans.concat(String.valueOf(permutations.get(j)));
                                ans = ans.concat(String.valueOf(permutations.get(j) + diff));
                                System.out.println(ans);
                            }
                        }
                    }
                }



            }
        }

        return ans;

    }

    private List<Integer> getPermutations(int num) {

        HashSet<Integer> permutations = new HashSet<>();

        List<Integer> digits=getDigits(num);

        int vis[]=new int[10];

        for(int i=0;i<digits.size();i++)
            vis[digits.get(i)]++;

        for(int i=0;i<digits.size();i++)
        {
            int digit=digits.get(i);
            if(digit!=0 && vis[digit]>0)
            {
                vis[digit]-=1;
                constructPermutations(digits,vis,digit,permutations);
                vis[digit]+=1;
            }
        }

        return new ArrayList<>(permutations);

    }

    private void constructPermutations(List<Integer> digits,int vis[],int combination,HashSet<Integer> permutations)
    {
        boolean flag=true;
        for(int i=0;i<digits.size();i++)
        {
            int digit=digits.get(i);
            if(vis[digit]>0)
            {
                flag=false;
                vis[digit]-=1;
                constructPermutations(digits,vis,combination*10+digit,permutations);
                vis[digit]+=1;
            }
        }

        if(flag)
        {
            permutations.add(combination);
        }
    }

    private boolean isPrime(int num)
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

    private List<Integer> getDigits(int num)
    {
        List<Integer> digits=new ArrayList<>();
        while(num>0)
        {
            digits.add(num%10);
            num=num/10;
        }
        return digits;
    }
}
