package com.java.rishabh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CodedTraingleNumbersMain {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new FileReader("src/resources/words.txt"));

        CodedTriangleNumbers codedTriangleNumbers=new CodedTriangleNumbers(br);
        codedTriangleNumbers.processInput();
        System.out.println("codedTriangleNumbers = " + codedTriangleNumbers.getCountOfCodedTriangleNumbers());
    }

}
