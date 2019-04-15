package com.java.rishabh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PathSumFourWaysMain {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("src/resources/matrix2.txt"));

        PathSumFourWays pathSumFourWays=new PathSumFourWays(br);
        pathSumFourWays.processInput();
        System.out.println(System.currentTimeMillis());
        System.out.println("pathSumFourWays = " + pathSumFourWays.getMinimalSum());
        System.out.println(System.currentTimeMillis());
    }

}
