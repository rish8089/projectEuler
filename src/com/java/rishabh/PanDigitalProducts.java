package com.java.rishabh;

/**
 * 6 digit number would take atleast 3 digits at multiplicand and multiplier 6+6=12 digits required
 * , but we have the scope of only distinct 9 digits.
 *
 * 3 digit numbers, 3 digits on right hand side, maximum 4 digits on left hand side.
 */

/**
 * 3 digit numbers, 3 digits on right hand side, maximum 4 digits on left hand side.
 */

import java.util.Arrays;

/**
 * no 5 digit numbers as well, as 5 digits on right hand side, would need atleast 5 digits on left hand side.
 */


public class PanDigitalProducts {

    int upperLim = 9999;
    int lowerLim = 1000;

    public int getSumOfPandigitalProducts() {

        int vis[]=new int[10];
        int sum=0;

        for (int i = lowerLim; i <= upperLim; i++) {

            Arrays.fill(vis,0);

            if(!check_digits_repeated(i,vis))
            {
                int visTemp[];

                for(int j=2;j*j<=i;j++)
                {
                    if(i%j==0 && j!=i/j)
                    {
                        visTemp=Arrays.copyOf(vis,10);


                        if(!check_digits_repeated(j,visTemp) && !check_digits_repeated(i/j,visTemp))
                        {
                            if(get_no_of_digits(j)+get_no_of_digits(i/j)==5)
                            {

                                System.out.println(j+" * "+i/j+" = "+i);
                                sum=sum+i;
                                break;
                            }
                        }
                    }
                }
            }




        }

        return sum;
    }

    boolean check_digits_repeated(int num,int vis[])
    {
        while(num>0)
        {
            int x=num%10;
            if(x==0)
                return true;

            if(vis[x-1]==1)
                return true;

            num=num/10;
            vis[x-1]=1;

        }

        return false;
    }

    int get_no_of_digits(int num)
    {
        int d=0;
        while(num>0)
        {
            d=d+1;
            num=num/10;
        }
        return d;
    }

}
