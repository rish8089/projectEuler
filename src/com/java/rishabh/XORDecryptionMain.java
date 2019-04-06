package com.java.rishabh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class XORDecryptionMain {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader=new BufferedReader(new FileReader("src/resources/cipher.txt"));

        XORDecryption xorDecryption=new XORDecryption(bufferedReader);
        xorDecryption.processInput();
        System.out.println("xorDecryption = " + xorDecryption.getSumOfASCIIValuesInOriginalText());
    }

}
