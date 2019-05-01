package com.java.rishabh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LargestProductInASeriesMain {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("src/resources/productseries.txt"));
        LargestProductInASeries largestProductInASeries=new LargestProductInASeries(br);
        largestProductInASeries.processInput();
        System.out.println("largestProductInASeries = " +  largestProductInASeries.getLargestProduct());

    }

}
