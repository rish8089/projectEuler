package com.java.rishabh;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * suite
 */
public class PokerHands {

    private BufferedReader br;
    private int lim = 1000;
    private int player1ValCnt[];
    private int player2ValCnt[];
    private int player1SuiteCnt[];
    private int player2SuiteCnt[];
    private List<String> pokerHands;

    PokerHands(BufferedReader br) {
        this.br = br;
        player1ValCnt = new int[15];
        player2ValCnt = new int[15];
        player1SuiteCnt=new int[5];
        player2SuiteCnt=new int[5];
        pokerHands = new ArrayList<>();
    }

    public void processInput() throws IOException {
        for (int i = 1; i <= lim; i++) {
            pokerHands.add(br.readLine());
        }
    }

    public int checkPokerHands() {

        int ans=0;

        for (int i = 0; i < pokerHands.size(); i++) {

            init();

            String[] str = pokerHands.get(i).split(" ");

            for (int j = 0; j < str.length; j++) {

                char ch0 = str[j].charAt(0);
                char ch1 = str[j].charAt(1);

                int val, suite;

                if (ch0 == 'T') {
                    val = 10;
                } else if (ch0 == 'J') {
                    val = 11;
                } else if (ch0 == 'Q') {
                    val = 12;
                } else if (ch0 == 'K') {
                    val = 13;
                } else if (ch0 == 'A') {
                    val = 14;
                } else {
                    val = ch0 - 48;
                }

                if (ch1 == 'C') {
                    suite = 1;
                } else if (ch1 == 'D') {
                    suite = 2;
                } else if (ch1 == 'H') {
                    suite = 3;
                } else {
                    suite = 4;
                }

                if (j < 5) {
                    player1ValCnt[val]++;
                    player1SuiteCnt[suite]++;

                } else {
                    player2ValCnt[val]++;
                    player2SuiteCnt[suite]++;
                }

                //data got structured, now process it

                //for player1,find the highest rank.
            }

            int player1Rank = 0;
            int player1Val = 0;
            int player2Rank = 0;
            int player2Val = 0;

            for (int j = 2; j <= 14; j++) {

                if (player1ValCnt[j] > 0) {
                    if (player1Rank <= 1) {
                        player1Rank = 1;
                        player1Val = j;//high card logic
                    }
                }

                if (player1ValCnt[j] == 2) {
                    if (player1Rank < 2) {
                        player1Rank = 2;
                        player1Val = j; //one pair
                    } else if (player1Rank == 2 || player1Rank == 3) {
                        player1Rank = 3;
                        player1Val = j; //two pairs
                    }
                } else if (player1ValCnt[j] == 3) {
                    if (player1Rank == 2) {
                        if (player1Rank <= 7) {
                            player1Rank = 7;
                            player1Val = j; //full house
                        }
                    } else {
                        if (player1Rank <= 4) {
                            player1Rank = 4;
                            player1Val = j; //three of a kind
                        }
                    }
                } else if (player1ValCnt[j] == 4) {
                    if (player1Rank <= 8) {
                        player1Rank = 8;
                        player1Val = j; //four of a kind.
                    }
                }

                if (j <= 10) {
                    if (player1ValCnt[j] == 1 && player1ValCnt[j + 1] == 1
                        && player1ValCnt[j + 2] == 1 && player1ValCnt[j + 3] == 1
                        && player1ValCnt[j + 4] == 1) {
                        if (player1Rank <= 5) {
                            player1Rank = 5;
                            player1Val = j; //straight
                        }
                    }
                }


            }

            for (int j = 2; j <= 14; j++) {

                if (player2ValCnt[j] > 0) {
                    if (player2Rank <= 1) {
                        player2Rank = 1;
                        player2Val = j;//high card logic
                    }
                }

                if (player2ValCnt[j] == 2) {
                    if (player2Rank < 2) {
                        player2Rank = 2;
                        player2Val = j; //one pair
                    } else if (player2Rank == 2 || player2Rank == 3) {
                        player2Rank = 3;
                        player2Val = j; //two pairs
                    }
                } else if (player2ValCnt[j] == 3) {
                    if (player2Rank == 2) {
                        if (player2Rank <= 7) {
                            player2Rank = 7;
                            player2Val = j; //full house
                        }
                    } else {
                        if (player2Rank <= 4) {
                            player2Rank = 4;
                            player2Val = j; //three of a kind
                        }
                    }
                } else if (player2ValCnt[j] == 4) {
                    if (player2Rank <= 8) {
                        player2Rank = 8;
                        player2Val = j; //four of a kind.
                    }
                }

                if (j <= 10) {
                    if (player2ValCnt[j] == 1 && player2ValCnt[j + 1] == 1
                        && player2ValCnt[j + 2] == 1 && player2ValCnt[j + 3] == 1
                        && player2ValCnt[j + 4] == 1) {
                        if (player2Rank <= 5) {
                            player2Rank = 5;
                            player2Val = j; //straight
                        }
                    }
                }


            }

            for (int j = 1; j <= 4; j++) //suite logic
            {
                if (player1SuiteCnt[j] == 5) {
                    //can be flush, but it can be straight flush or royal flush as well
                    if (player1Rank == 5) {

                        if (player1Val == 10) {
                            player1Rank = 10;
                        } else {
                            player1Rank = 9;
                        }
                    } else {
                        if (player1Rank <= 6) {
                            player1Rank = 6; //player1Val not needed in this case.
                            player1Val=0;
                        }
                    }
                }
            }

            for (int j = 1; j <= 4; j++) //suite logic
            {
                if (player2SuiteCnt[j] == 5) {
                    //can be flush, but it can be straight flush or royal flush as well
                    if (player2Rank == 5) { //checking if straight

                        if (player2Val == 10) {
                            player2Rank = 10;
                        } else {
                            player2Rank = 9;
                        }
                    } else {
                        if (player2Rank <= 6) {
                            player2Rank = 6;
                            player2Val=0;
                        }
                    }
                }
            }

            /*System.out.println("player1");
            System.out.println("rank = "+player1Rank);
            System.out.println("value = "+player1Val);

            System.out.println("player2");
            System.out.println("rank = "+player2Rank);
            System.out.println("value = "+player2Val);*/

            if(player1Rank>player2Rank)
            {
                ans+=1;
            }
            else if(player1Rank==player2Rank && player1Val>player2Val)
            {
                ans+=1;
            }
            else if(player1Rank==player2Rank && player1Val==player2Val)
            {
                boolean flag=false;
                for(int j=14;j>=2;j--)
                {
                    if(player1ValCnt[j]>player2ValCnt[j])
                    {
                        flag=true;
                        break;
                    }
                    else if(player2ValCnt[j]>player1ValCnt[j])
                    {
                        break;
                    }
                }

                if(flag)
                    ans+=1;
            }

        }

        return ans;
    }

    private void init() {
        Arrays.fill(player1ValCnt, 0);
        Arrays.fill(player2ValCnt, 0);
        Arrays.fill(player1SuiteCnt, 0);
        Arrays.fill(player2SuiteCnt, 0);
    }

}
