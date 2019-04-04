package com.java.rishabh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MaximumPathSumIIMain {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new FileReader("src/resources/triangle.txt"));

        MaximumPathSumII maximumPathSumII=new MaximumPathSumII(br);
        maximumPathSumII.processInput();
        System.out.println("maximumPathSumII = " + maximumPathSumII.getMaximumSum());
    }

}
