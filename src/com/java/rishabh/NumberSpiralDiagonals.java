package com.java.rishabh;

public class NumberSpiralDiagonals {

    int lim=1001;

    public int getSumOfSpiralDiagonals()
    {
        int sum=1;
        int last_diagonal_num=1;

        for(int i=3;i<=lim;i+=2)
        {
            int top_right_corner=last_diagonal_num+(i-1);
            sum+=2*(2*top_right_corner+3*(i-1));

            last_diagonal_num=top_right_corner+3*(i-1);

        }
        return sum;
    }

}
