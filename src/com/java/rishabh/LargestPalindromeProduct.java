package com.java.rishabh;

public class LargestPalindromeProduct {

    public int getLargestPalindromeProduct()
    {
        int ans=0;
        for(int i=100;i<=999;i++)
        {
            for(int j=100;j<=999;j++)
            {
                if(isPalindrome(i*j))
                {
                    if(ans<i*j)
                        ans=i*j;
                }
            }
        }

        return ans;
    }

    private boolean isPalindrome(int num)
    {
        int s=0;
        int m=num;
        while(num>0)
        {
            int x=num%10;
            s=s*10+x;
            num=num/10;
        }

        if(m==s)
            return true;
        else
            return false;
    }

}
