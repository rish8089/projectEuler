package com.java.rishabh;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class MonopolyOddsStatistically {

    int lim = 10000000;

    private static final int JAIL = 10;
    private static final int GOTOJAIL = 30;
    private static final int GO = 0;
    private static final int CC1 = 2;
    private static final int CC2 = 17;
    private static final int CC3 = 33;
    private static final int CH1 = 7;
    private static final int CH2 = 22;
    private static final int CH3 = 36;
    private static final int C1 = 11;
    private static final int E3 = 24;
    private static final int H2 = 39;
    private static final int R1 = 5;
    private static final int R2 = 15;
    private static final int R3 = 25;
    private static final int U1 = 12;
    private static final int U2 = 28;
    private static final int T1 = 4;
    private static final int D3 = 19;

    Node cnt[];
    int ccCards[] = {GO, JAIL, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    int ch1Cards[] = {GO, JAIL, C1, E3, H2, R1, R2, R2, U1, T1, -1, -1, -1, -1, -1, -1};
    int ch2Cards[] = {GO, JAIL, C1, E3, H2, R1, R3, R3, U2, D3, -1, -1, -1, -1, -1, -1};
    int ch3Cards[] = {GO, JAIL, C1, E3, H2, R1, R1, R1, U1, CC3, -1, -1, -1, -1, -1, -1};

    MonopolyOddsStatistically() {
        cnt = new Node[40];
        for(int i=0;i<cnt.length;i++) {
            cnt[i] = new Node();
            cnt[i].idx=i;
            cnt[i].val=0;
        }
    }

    public String getSixDigitModalString() {
        int i = 1;
        int currentPos = 0;
        int ccPos = 0;
        int chPos = 0;
        int doubles = 0;

        Random randomGenerator = new Random();

        while (i <= lim) {
            int dice1 = randomGenerator.nextInt(4) + 1;
            int dice2 = randomGenerator.nextInt(4) + 1;

            if (dice1 == dice2 && doubles == 2) {
                currentPos = JAIL;//final position
                doubles = 0;
            } else {
                doubles = (dice1 == dice2) ? (doubles + 1) : 0;
                currentPos = (currentPos + dice1 + dice2) % 40;

                if (currentPos == GOTOJAIL) {
                    currentPos = JAIL;
                } else if (currentPos == CC1 || currentPos == CC2 || currentPos == CC3) {
                    int ccCardPos = ccPos % 16;
                    ccPos++;

                    if (ccCardPos < 2) {
                        currentPos = ccCards[ccCardPos];
                    }
                } else if (currentPos == CH1 || currentPos == CH2 || currentPos == CH3) {
                    int chCardPos = chPos % 16;
                    chPos++;

                    if (currentPos == CH1) {
                        if (chCardPos < 10) {
                            currentPos = ch1Cards[chCardPos];
                        }
                    } else if (currentPos == CH2) {
                        if (chCardPos < 10) {
                            currentPos = ch2Cards[chCardPos];
                        }
                    } else {
                        if (chCardPos < 9) {
                            currentPos = ch3Cards[chCardPos];
                        } else if(chCardPos==9) {
                            int ccCardPos = ccPos % 16;
                            ccPos++;

                            if (ccCardPos < 2) {
                                currentPos = ccCards[ccCardPos];
                            }

                        }
                    }
                }
            }

            cnt[currentPos].val++;
            i++;

        }

        Arrays.sort(cnt, new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                if(node1.val==node2.val)
                    return 0;
                else if(node1.val<node2.val)
                    return -1;
                else
                    return 1;
            }
        });

        for (i = 0; i < cnt.length; i++) {
            System.out.println(cnt[i].val+ " "+cnt[i].idx);
        }

        return "";
    }

    class Node
    {
        int idx;
        int val;
    }

}
