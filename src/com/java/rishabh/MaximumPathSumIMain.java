package com.java.rishabh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MaximumPathSumIMain {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader=new BufferedReader(new FileReader("src/resources/triangle2.txt"));
        MaximumPathSumI maximumPathSumI=new MaximumPathSumI(bufferedReader);
        maximumPathSumI.processInput();
        System.out.println("maximumPathSumI = " + maximumPathSumI.getMaximumPathSum());
    }

}
