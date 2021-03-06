package com.java.rishabh;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XORDecryption {

    List<Integer> encryptedCodes;
    BufferedReader br;

    XORDecryption(BufferedReader br) {
        this.br = br;
        encryptedCodes = new ArrayList<>();
    }

    public void processInput() throws IOException {
        String arr[] = br.readLine().split(",");
        for (String str : arr) {
            encryptedCodes.add(Integer.parseInt(str));
        }
    }

    public int getSumOfASCIIValuesInOriginalText() {

        int ans = 0;
        for (int i = 4; i <5 ; i++) {
            for (int j = 23; j < 24; j++) {
                for (int k = 15; k < 16; k++) {
                    boolean flag = true;
                    //System.out.println((char)(i+97)+","+(char)(j+97)+","+(char)(k+97));
                    int sum = 0;
                    for (int l = 0; l < encryptedCodes.size(); l++) {
                        int encryptedCode = encryptedCodes.get(l);
                        int decryptedCode = 0;
                        if (l % 3 == 0) {
                            decryptedCode = encryptedCode ^ (i + 97);
                        } else if (l % 3 == 1) {
                            decryptedCode = encryptedCode ^ (j + 97);
                        } else {
                            decryptedCode = encryptedCode ^ (k + 97);
                        }

                        sum = sum + decryptedCode;
                        System.out.print((char)decryptedCode);

                        if (!isAsciiCodeValid(decryptedCode)) {
                            flag = false;
                            /*System.out.println(
                                "i = " + i + " j = " + j + " k = " + k + " decryptedCode = "
                                    + (char)decryptedCode);*/
                            break;
                        }
                    }
//                    for (int l = 0; l < encryptedCodes.size(); l += 3) {
//                        int encryptedCode1 = encryptedCodes.get(l);
//                        int encryptedCode2 = encryptedCodes.get(l + 1);
//                        int encryptedCode3 = encryptedCodes.get(l + 2);
//                        int decryptedCode1 = encryptedCode1 ^ (i + 97);
//                        int decryptedCode2 = encryptedCode2 ^ (j + 97);
//                        int decryptedCode3 = encryptedCode3 ^ (k + 97);
//
//                        if (!isAsciiCodeValid(decryptedCode1) || !isAsciiCodeValid(decryptedCode2)
//                            || !isAsciiCodeValid(decryptedCode3)) {
//                            flag = false;
//                            /*System.out.println(
//                                "decryptedCode1 = " + (char) decryptedCode1 + ", decryptedCode2 = "
//                                    + (char) decryptedCode2 + ",decryptedCode3 = "
//                                    + (char) decryptedCode3);*/
//                            break;
//                        }
//
//
//                    }

                    if (flag) {
                        ans = sum;
                    }
                }
            }
        }

        System.out.println();

        return ans;
    }

    private boolean isAsciiCodeValid(int code) {
        if ((code >= 32 && code <=90) || (code >= 97 && code <= 122) || code==91 || code==93) {
            return true;
        } else {
            return false;
        }
    }

}
