package com.java.rishabh;

import java.util.ArrayList;
import java.util.List;

public class CoinPartitions {

    int lim = 1000000;

    CoinPartitions() {


    }

    public int getCoinPartitions() {

        int n=1;

        List<Integer> p=new ArrayList<>();
        p.add(1);

        while(true)
        {

            int r=1;
            p.add(0);
            int penta=1;
            while(penta<=n)
            {
                if(r%2!=0)
                    p.set(p.size()-1,(p.get(p.size()-1)+p.get(n-penta))%lim);
                else
                    p.set(p.size()-1,(p.get(p.size()-1)-p.get(n-penta)+lim)%lim);

                penta=penta+r;

                if(penta<=n) {
                    if (r % 2 != 0)
                        p.set(p.size() - 1, (p.get(p.size() - 1) + p.get(n - penta)) % lim);
                    else
                        p.set(p.size()-1,(p.get(p.size()-1)-p.get(n-penta)+lim)%lim);
                }
                else
                    break;

                r++;
                penta=r*(3*r-1)/2;

            }

            if(p.get(p.size()-1)==0)
                break;

            n++;

        }

        for (int val : p) {
            System.out.println("val = " + val);
        }

        return n;

    }


}
