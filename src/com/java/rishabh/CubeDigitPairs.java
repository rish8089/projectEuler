package com.java.rishabh;

public class CubeDigitPairs {


    int arr1[];
    int arr2[];

    CubeDigitPairs()
    {
        arr1=new int[6];
        arr2=new int[6];
    }

    public int getDistinctCombinations()
    {
        return recurse(0,0);
    }




    private int recurse(int nextValidDigit,int idx)
    {
        int cnt=0;

        if(idx==12)
        {
            if(validateCombination())
                return 1;
            else
                return 0;
        }

        if(idx<=5) {
            for (int i = nextValidDigit; i <= 9; i++) {
                arr1[idx]=i;
                if(idx<5)
                    cnt+=recurse(i+1,idx+1);
                else
                    cnt+=recurse(0,idx+1);
            }
        }
        else
        {
            for(int i=nextValidDigit;i<=9;i++)
            {
                arr2[idx%6]=i;
                cnt+=recurse(i+1,idx+1);


            }
        }
        return cnt;
    }

    private boolean validateCombination()
    {

        boolean flag=true;

        int hash1[]=new int[10];
        int hash2[]=new int[10];

        for(int i=0;i<6;i++)
            hash1[arr1[i]]=1;
        for(int i=0;i<6;i++)
            hash2[arr2[i]]=1;

        if(!((hash1[0]==1 && hash2[1]==1) || (hash1[1]==1 && hash2[0]==1))) //01 cannot be constructed
            return false;

        else if(!((hash1[0]==1 && hash2[4]==1) || (hash1[4]==1 && hash2[0]==1)))
            return false;

        else if(!((hash1[0]==1 && hash2[9]==1) || (hash1[9]==1 && hash2[0]==1) || (hash1[0]==1 && hash2[6]==1) || (hash1[6]==1 && hash2[0]==1)))
            return false;

        else if(!((hash1[2]==1 && hash2[5]==1) || (hash1[5]==1 && hash2[2]==1)))
            return false;

        else if(!((hash1[1]==1 && hash2[8]==1) || (hash1[8]==1 && hash2[1]==1)))
            return false;

        else if(!((hash1[1]==1 && hash2[6]==1) || (hash1[6]==1 && hash2[1]==1) || (hash1[9]==1 && hash2[1]==1) || (hash1[1]==1 && hash2[9]==1)))
            return false;

        else if(!((hash1[4]==1 && hash2[9]==1) || (hash1[9]==1 && hash2[4]==1) || (hash1[4]==1 && hash2[6]==1) || (hash1[6]==1 && hash2[4]==1)))
            return false;

        else if(!((hash1[3]==1 && hash2[9]==1) || (hash1[9]==1 && hash2[3]==1) || (hash1[3]==1 && hash2[6]==1) || (hash1[6]==1 && hash2[3]==1)))
            return false;

        return flag;




    }



}
