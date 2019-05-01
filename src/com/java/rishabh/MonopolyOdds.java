package com.java.rishabh;

public class MonopolyOdds {

    int visited[][][][][][];
    int cnt[];

    private static final int JAIL=10;
    private static final int GOTOJAIL=30;
    private static final int GO=0;
    private static final int CC1=2;
    private static final int CC2=17;
    private static final int CC3=33;
    private static final int CH1=7;
    private static final int CH2=22;
    private static final int CH3=36;
    private static final int C1=11;
    private static final int E3=24;
    private static final int H2=39;
    private static final int R1=5;
    private static final int R2=15;
    private static final int R3=25;
    private static final int U1=12;
    private static final int U2=28;
    private static final int T1=4;
    private static final int D3=19;

    int ccCards[]={GO,JAIL,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    int ch1Cards[]={GO,JAIL,C1,E3,H2,R1,R2,R2,U1,T1,-1,-1,-1,-1,-1,-1};
    int ch2Cards[]={GO,JAIL,C1,E3,H2,R1,R3,R3,U2,D3,-1,-1,-1,-1,-1,-1};
    int ch3Cards[]={GO,JAIL,C1,E3,H2,R1,R1,R1,U1,CC3,-1,-1,-1,-1,-1,-1};
    int normalCards[]={-1};
    int goToJailCards[]={JAIL};

    MonopolyOdds()
    {
        visited=new int[40][7][7][3][16][40];
        cnt=new int[40];
    }

    public String getSixDigitModalString()
    {
        String ans="";
        recurse(0,0);

        int sum=0;
        for (int i = 0; i <= 39; i++) {
            System.out.println("i = "+i+" cnt = "+cnt[i]);
            sum=sum+cnt[i];
        }

        System.out.println("sum = " + sum);


        return ans;
    }

    private void recurse(int source,int doubles)
    {
        for(int i=1;i<=6;i+=1)
        {
            for(int j=1;j<=6;j+=1)
            {

                    if(i==j && doubles==2)
                    {
                        for(int k=0;k<goToJailCards.length;k++) {

                            if(visited[source][i][j][0][k][k]==0) {

                                visited[source][i][j][0][k][k]=1;
                                cnt[goToJailCards[k]] += 1;

                                recurse(goToJailCards[k], 0);
                            }
                        }
                    }
                    else {

                        int num = (source + i + j) % 40;
                        int temp= (i == j) ? doubles + 1 : 0;
                        if (num == GOTOJAIL) // go to jail
                        {
                            for(int k=0;k<goToJailCards.length;k++) {



                                if(visited[source][i][j][temp][k][k]==0) {

                                    visited[source][i][j][temp][k][k]=1;
                                    cnt[goToJailCards[k]] += 1;

                                    recurse(goToJailCards[k],temp);
                                }
                            }
                        }

                        else if(num==CC1 || num==CC2 || num==CC3)
                        {
                            for(int k=0;k<ccCards.length;k++)
                            {
                                if(visited[source][i][j][temp][k][k]==0) {

                                    visited[source][i][j][temp][k][k]=1;

                                    if (ccCards[k] != -1) {
                                        cnt[ccCards[k]] += 1;
                                        recurse(ccCards[k],temp);
                                    } else {
                                        cnt[num] += 1;
                                        recurse(num,temp);
                                    }
                                }
                            }
                        }

                        else if(num==CH1 || num==CH2 || num==CH3)
                        {
                            if(num==CH1)
                            {
                                for(int k=0;k<ch1Cards.length;k++)
                                {
                                    if(visited[source][i][j][temp][k][k]==0) {

                                        visited[source][i][j][temp][k][k]=1;

                                        if (ch1Cards[k] != -1) {
                                            cnt[ch1Cards[k]] += 1;
                                            recurse(ch1Cards[k], temp);
                                        } else {
                                            cnt[num] += 1;
                                            recurse(num, temp);
                                        }
                                    }
                                }
                            }

                            else if(num==CH2)
                            {
                                for(int k=0;k<ch2Cards.length;k++)
                                {
                                    if(visited[source][i][j][temp][k][k]==0) {

                                        visited[source][i][j][temp][k][k]=1;

                                        if (ch2Cards[k] != -1) {
                                            cnt[ch2Cards[k]] += 1;
                                            recurse(ch2Cards[k], temp);
                                        } else {
                                            cnt[num] += 1;
                                            recurse(num, temp);
                                        }
                                    }
                                }
                            }

                            else
                            {
                                for(int k=0;k<ch3Cards.length;k++)
                                {
                                    if(ch3Cards[k]==CC3)
                                    {
                                        for(int l=0;l<ccCards.length;l++)
                                        {
                                            if(visited[source][i][j][temp][k][16+l]==0) {

                                                visited[source][i][j][temp][k][16+l]=1;

                                                if (ccCards[l] != -1) {
                                                    cnt[ccCards[l]] += 1;
                                                    recurse(ccCards[l],temp);
                                                } else {
                                                    cnt[num] += 1;
                                                    recurse(num,temp);
                                                }
                                            }
                                        }
                                    }
                                    else {

                                        if (visited[source][i][j][temp][k][k] == 0) {

                                            visited[source][i][j][temp][k][k] = 1;

                                            if (ch3Cards[k] != -1) {
                                                cnt[ch3Cards[k]] += 1;
                                                recurse(ch3Cards[k], temp);
                                            } else {
                                                cnt[num] += 1;
                                                recurse(num, temp);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        else
                        {
                            for(int k=0;k<normalCards.length;k++) {
                                if(visited[source][i][j][temp][k][k]==0) {

                                    visited[source][i][j][temp][k][k]=1;

                                    cnt[num] += 1;
                                    recurse(num,temp);
                                }
                            }
                        }




                    }






            }
        }

    }

}
