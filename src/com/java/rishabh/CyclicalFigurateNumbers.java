package com.java.rishabh;

import java.util.ArrayList;
import java.util.List;

public class CyclicalFigurateNumbers {

    List<List<Integer>> list;
    int lim=10000;
    int visited[];
    int res[];

    CyclicalFigurateNumbers()
    {
        list=new ArrayList<>();
        visited=new int[10];
        res=new int[10];//result array
    }

    public int geSumOfSixCyclicallyOrderedFourDigitNumbers()
    {
        int n;
        int val;
        for(int i=1;i<=6;i++)
        {
            List<Integer> subList=new ArrayList<>();
            if(i==1)
            {
                n=1;
                while(true)
                {
                    val=n*(n+1)/2;
                    if(val<lim)
                    {
                        if(getNoOfDigits(val)==4) {
                            subList.add(val);
                        }
                        n=n+1;
                    }
                    else
                        break;
                }

            }

            else if(i==2)
            {
                n=1;
                while(true)
                {
                    val=n*n;
                    if(val<lim)
                    {
                        if(getNoOfDigits(val)==4) {
                            subList.add(val);
                        }
                        n=n+1;
                    }
                    else
                        break;
                }
            }
            else if(i==3)
            {
                n=1;
                while(true)
                {
                    val=n*(3*n-1)/2;
                    if(val<lim)
                    {
                        if(getNoOfDigits(val)==4) {
                            subList.add(val);
                        }
                        n=n+1;
                    }
                    else
                        break;
                }
            }

            else if(i==4)
            {
                n=1;
                while(true)
                {
                    val=n*(2*n-1);
                    if(val<lim)
                    {
                        if(getNoOfDigits(val)==4) {
                            subList.add(val);
                        }
                        n=n+1;
                    }
                    else
                        break;
                }
            }
            else if(i==5)
            {
                n=1;
                while(true)
                {
                    val=n*(5*n-3)/2;
                    if(val<lim)
                    {
                        if(getNoOfDigits(val)==4) {
                            subList.add(val);
                        }
                        n=n+1;
                    }
                    else
                        break;
                }
            }
            else
            {
                n=1;
                while(true)
                {
                    val=n*(3*n-2);
                    if(val<lim)
                    {
                        if(getNoOfDigits(val)==4) {
                            subList.add(val);
                        }
                        n=n+1;
                    }
                    else
                        break;
                }
            }



            list.add(subList);
        }

        List<String> permutations=getAllPermutations(6,0,"");

        for(String permutation:permutations)
        {
            if(recurse(permutation,0))
                break;
        }

        int sum=0;
        for (int element : res) {
            sum=sum+element;
        }

        return sum;
    }

    private List<String> getAllPermutations(int n,int cnt,String permutation)
    {
        List<String> permutations=new ArrayList<>();

        if(cnt==6) {
            permutations.add(permutation);
            return permutations;
        }


        for(int i=1;i<=n;i++)
        {
            if(visited[i]==0) {
                visited[i] = 1;
                permutations.addAll(getAllPermutations(n, cnt + 1,permutation+i));
                visited[i] = 0;
            }
        }

        return permutations;
    }

    private boolean recurse(String permutation,int cnt)
    {
        /*if(cnt==6)
            return true;
        else {*/

            int idx = permutation.charAt(cnt) - 49;

            List<Integer> subList = list.get(idx);
            for (Integer num : subList) {
                if (cnt - 1 >= 0) {

                    if(areLastTwoDigitsAndFirstTwoDigitsSame(num,res[cnt-1]))
                    {
                        if(cnt==5)
                        {
                            if(areLastTwoDigitsAndFirstTwoDigitsSame(res[0],num)) {
                                res[cnt]=num;
                                /*boolean ret=recurse(permutation, cnt + 1);
                                if(ret)*/
                                    return true;
                            }
                        }
                        else {
                            res[cnt]=num;
                            boolean ret=recurse(permutation, cnt + 1);
                            if(ret)
                                return true;
                        }
                    }
                }
                else
                {
                    res[cnt]=num;
                    boolean ret=recurse(permutation,cnt+1);
                    if(ret)
                        return  true;
                }
            }

            return false;


    }

    private int getNoOfDigits(int num)
    {
        int d=0;
        while(num>0)
        {
            d=d+1;
            num=num/10;
        }

        return d;
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

    private boolean areLastTwoDigitsAndFirstTwoDigitsSame(int num1,int num2)
    {
        int val1,val2;
        List<Integer> digits = getDigits(num1);
        val1 = digits.get(3) * 10 + digits.get(2);
        digits = getDigits(num2);
        val2 = digits.get(1) * 10 + digits.get(0);
        return val1==val2;
    }

}
