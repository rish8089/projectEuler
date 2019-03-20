package com.java.rishabh;

public class DoubleBasePalindromes {

    int lim=1000000;

    public long getSumOfDoubleBasePalindromes()
    {
        long ans=0;
        for(int i=1;i<lim;i++)
        {
            if(isPalindrome(i) && isPalindrome(Integer.toBinaryString(i)))
            {
                ans=ans+i;
            }
        }
        return ans;
    }

    private boolean isPalindrome(String val)
    {
        boolean res=true;
        int n=val.length();
        for(int i=0;i<n/2;i++)
        {
            if(val.charAt(i)!=val.charAt(n-i-1))
                res=false;
        }
        return res;
    }

    private boolean isPalindrome(int val)
    {
        int s=0,x;
        int valtmp=val;
        while(val>0)
        {
            x=val%10;
            val=val/10;
            s=s*10+x;
        }
        if(s==valtmp)
            return true;
        else
            return false;
    }

}