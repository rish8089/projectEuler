package com.java.rishabh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PokerHandsMain {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("src/resources/poker.txt"));

        PokerHands pokerHands=new PokerHands(br);
        pokerHands.processInput();
        System.out.println("pokerHands = "+pokerHands.checkPokerHands());

    }

}
