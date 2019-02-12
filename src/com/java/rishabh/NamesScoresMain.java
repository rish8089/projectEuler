package com.java.rishabh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NamesScoresMain {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("src/resources/names.txt"));

        NamesScores namesScores=new NamesScores(br);
        namesScores.processInput();
        System.out.println(namesScores.getTotalNameScores());

    }

}
