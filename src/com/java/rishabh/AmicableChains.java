package com.java.rishabh;

public class AmicableChains {

    int lim = 1000000;
    boolean visited[];
    boolean hash[];
    int order[];

    AmicableChains() {
        visited = new boolean[lim + 1];
        order = new int[lim + 1];
        hash=new boolean[lim+1];
    }

    public int getSmallestMemberInLongestAmicableChain() {

        int maxLen = 0, ans = -1;

        for (int i = 2; i <= lim; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[i] = 1;
                int ret = recurse(i);
                if (ret > order[i] || ret == 0) {
                    order[i] = 0;
                } else {
                    order[i] = order[i] - ret + 1;
                }
            }

            if (maxLen <order[i]) {
                maxLen = order[i];
                ans=getMinimumInMaxLengthChain(i);
            }
        }


        return ans;

    }

    private int getMinimumInMaxLengthChain(int i)
    {
        int min=i;
        hash[i]=true;
        int sumOfdivisors = getSumOfDivisors(i);
        if(!hash[sumOfdivisors])
        {
            int ret=getMinimumInMaxLengthChain(sumOfdivisors);
            if(ret!=-1 && min>ret)
                min=ret;
            return min;
        }
        else
            return -1;



    }

    private int recurse(int i) {
        int sumOfdivisors = getSumOfDivisors(i);
        if (sumOfdivisors == 1 || sumOfdivisors > lim) //should not exceed lim as per question
        {
            return 0;

        } else if (!visited[sumOfdivisors]) {

            visited[sumOfdivisors] = true;
            order[sumOfdivisors] = order[i] + 1;//maintaining the order
            int ret = recurse(sumOfdivisors);
            //either we can get 0 or proper chain length
            if (ret > order[sumOfdivisors] || ret == 0) {
                order[sumOfdivisors] = 0;
                return 0;
            } else {
                order[sumOfdivisors] = order[sumOfdivisors] - ret + 1;
                return ret;
            }


        } else {
            //its already visited
            return order[sumOfdivisors];

        }


    }

    private int getSumOfDivisors(int num) {
        int sum = 0;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                if (num / i != i) {
                    sum += num / i + i;
                } else {
                    sum += i;
                }
            }
        }
        return sum + 1;
    }



}
