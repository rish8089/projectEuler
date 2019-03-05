package com.java.rishabh;

public class LexicographicPermutations {

    int num=1000000;
    int fact[];

    LexicographicPermutations()
    {
        fact=new int[11];
    }

    public StringBuilder getOneMillionthPermutation() {

        computeFactorials();
        return constructOneMillionthPermutation(num);
    }

    private void computeFactorials() {
        for (int i = 1; i <= 10; i++) {
            fact[i] = 1;
            for (int j = 1; j <= i; j++) {
                fact[i] = fact[i] * j;
            }
        }
    }

    private StringBuilder constructOneMillionthPermutation(int num)
    {
        StringBuilder str=new StringBuilder("0123456789");
        StringBuilder ans=new StringBuilder();
        int x;

        while(num>0)
        {
            x=num/fact[str.length()-1];
            num=num-x*fact[str.length()-1];

            if(num>0)
            {
                ans=ans.append(str.charAt(x));
                str.deleteCharAt(x);
            }
            else
            {
                ans=ans.append(str.charAt(x-1));
                str.deleteCharAt(x-1);
            }

        }

        ans=ans.append(str.reverse());
        return ans;
    }

}
