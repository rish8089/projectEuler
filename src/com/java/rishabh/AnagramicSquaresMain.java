package com.java.rishabh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AnagramicSquaresMain {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new FileReader("src/resources/words1.txt"));

        AnagramicSquares anagramicSquares=new AnagramicSquares(br);
        anagramicSquares.processInput();
        System.out.println("anagramicSquares = " + anagramicSquares.getLargestSquareFormed());
    }

}
