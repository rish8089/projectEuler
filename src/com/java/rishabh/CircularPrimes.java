package com.java.rishabh;

public class CircularPrimes {

    int lim=1000000;
    int sieve[];

    CircularPrimes()
    {
        sieve=new int[lim+1];
    }

    public int getNoOfCircularPrimes()
    {
        //calculating primes

        int cnt=0;

        for(int i=2;i*i<=lim;i++)
        {
            if(sieve[i]==0) {
                for (int j = i * i; j <= lim; j += i) {
                    sieve[j]=1;
                }
            }
        }

        for(int i=2;i<=lim;i++)
        {
            int num_of_digits=getNoOfDigits(i);

            int num=i;

            int power_of_ten=(int)Math.pow(10,num_of_digits-1);

            boolean flag=true;

            for(int j=1;j<=num_of_digits;j++)
            {
                int x=num%10;
                num=x*power_of_ten+num/10;

                if(sieve[num]!=0)
                {
                    flag=false;
                    break;
                }

            }

            if(flag) {
                cnt += 1;
                System.out.println(i);
            }

        }

        return cnt;


    }

    private int getNoOfDigits(int num)
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
