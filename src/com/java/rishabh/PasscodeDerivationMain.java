package com.java.rishabh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PasscodeDerivationMain {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new FileReader("src/resources/keylog.txt"));

        PasscodeDerivation passcodeDerivation=new PasscodeDerivation(br);
        passcodeDerivation.processInput();
        passcodeDerivation.getShortestPossibleSecret();
    }

}
