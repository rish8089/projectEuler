package com.java.rishabh;

import java.util.ArrayList;
import java.util.List;

public class DiophantineEquation {

    /*int lim = 1000;
    int solution[];
    int Dlim = 1000;

    DiophantineEquation() {
        solution = new int[lim + 1];
    }

    public int getMaximalX() {
        /*List<Integer> squares = new ArrayList<>();
        int i = 1, D;
        while (i < lim) {
            squares.add(i * i);
            i++;
        }

        for (i = 1; i < squares.size(); i++) {
            int num = squares.get(i) - 1;//(x^2-1)
            for (int j = 0; j < squares.size() && squares.get(j)< num; j++) {
                if (num % squares.get(j) == 0) {
                    D = num / squares.get(j); //thats great
                    if (D <= Dlim) {
                        if (solution[D] == 0) //not set still
                        {
                            solution[D] = i + 1; //x=i+1
                        }
                    }
                }
            }
        }

        for(i=2;i<=1000;i++)
        {
            if(!isPerfectSquare())
        }

        return 0;

    }

    private boolean isPerfectSquare(int num) {
        int x = (int) Math.sqrt(num);
        return x * x == num;
    }*/

    int lim=1000;

    public long getMaximalX()
    {
        long max=0,ans=-1;
        for(int i=109;i<=109;i++)
        {
            long y=1;
            long val=isPerfectSquare(i);
            if(val==-1) {
                while (true) {

                    val=isPerfectSquare(1 + i * y * y);
                    if(val!=-1)
                    {
                        System.out.println("i = " +i +",val = " + val);
                        if(max<val) {
                            max = val;
                            ans=i;
                        }
                        break;
                    }

                    y++;
                }
            }
        }

        System.out.println("max = " + max);
        return ans;
    }

    private long isPerfectSquare(long num)
    {
        long x=(long)Math.sqrt(num);
        if(x*x==num)
            return x;
        else
            return -1;
    }

}
