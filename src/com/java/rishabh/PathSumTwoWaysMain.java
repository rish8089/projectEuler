package com.java.rishabh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PathSumTwoWaysMain {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new FileReader("src/resources/matrix.txt"));

        PathSumTwoWays pathSumTwoWays=new PathSumTwoWays(br);
        pathSumTwoWays.processInput();
        System.out.println("pathSumTwoWays = " + pathSumTwoWays.getMinimumPathSum());
    }

}
