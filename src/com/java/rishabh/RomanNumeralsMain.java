package com.java.rishabh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RomanNumeralsMain {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new FileReader("src/resources/roman.txt"));

        RomanNumerals romanNumerals=new RomanNumerals(br);
        romanNumerals.processInput();
        System.out.println("romanNumerals = " + romanNumerals.convertToRoman());
    }

}
