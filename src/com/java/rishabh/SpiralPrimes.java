package com.java.rishabh;

public class SpiralPrimes {

    public long getLengthOfSpiral() {

        int cnt=0;
        boolean flag=false;
        long ans=-1;
        for (long i = 2;true; i+=2) {

            long square=i*i+1;

            if(square<0) {
                flag = false;
                break;
            }

            if(isPrime(square))
                cnt+=1;

            if(isPrime(square-i))
                cnt+=1;

            if(isPrime(square+i))
                cnt+=1;

            System.out.println(cnt + " "+(2*(i+1)-1));
            if(10*cnt<2*(i+1)-1)
            {
                ans=i+1;
                break;
            }





        }

        if (flag) {
            System.out.println("exceeding range");
        }

        return ans;


    }

    boolean isPrime(long num)
    {

        for(long i=2;i*i<=num;i++)
        {
            if(num%i==0)
            {
                return false;
            }
        }

        return true;
    }


}
