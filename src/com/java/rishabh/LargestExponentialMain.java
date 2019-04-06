package com.java.rishabh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LargestExponentialMain {


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("src/resources/base_exp.txt"));

        LargestExponential largestExponential=new LargestExponential(br);
        largestExponential.processInput();
        System.out.println("largestExponential = " + largestExponential.getIndexWithLargestValue());

    }
}
