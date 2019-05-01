package com.java.rishabh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LargeSumMain {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("src/resources/largesum.txt"));
        LargeSum largeSum=new LargeSum(br);
        largeSum.processInput();
        System.out.println("largeSum = " + largeSum.getLargeSum());
    }

}
