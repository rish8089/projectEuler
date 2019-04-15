package com.java.rishabh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PathSumThreeWaysMain {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("src/resources/matrix1.txt"));

        PathSumThreeWays pathSumThreeWays=new PathSumThreeWays(br);
        pathSumThreeWays.processInput();
        System.out.println(System.currentTimeMillis());
        System.out.println("pathSumThreeWays = " + pathSumThreeWays.getMinimalSum());
        System.out.println(System.currentTimeMillis());
    }

}
