package com.java.rishabh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LargestProductInAgridMain {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("src/resources/productgrid.txt"));

        LargestProductInAgrid largestProductInAgrid=new LargestProductInAgrid(br);
        largestProductInAgrid.processInput();
        System.out.println("largestProductInAgrid = " + largestProductInAgrid.getLargestProductInGrid());
    }
}
