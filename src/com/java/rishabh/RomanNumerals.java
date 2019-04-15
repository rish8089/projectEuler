package com.java.rishabh;

import java.io.BufferedReader;
import java.io.IOException;

public class RomanNumerals {


    int A[] = {1000, 500, 100, 50, 10, 5, 1};
    char B[] = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
    int hash[];
    String romanNumerals[];
    int lim = 1000;
    private BufferedReader br;

    RomanNumerals(BufferedReader br) {
        hash = new int[26];
        romanNumerals = new String[lim + 1];
        this.br = br;
        for (int i = 0; i < B.length; i++) {
            hash[B[i] - 65] = A[i];
        }
    }

    public void processInput() throws IOException {
        for (int i = 0; i < 1000; i++) {
            romanNumerals[i] = br.readLine();
        }
    }

    public int convertToRoman() {

        int characterSaved=0;
        for (int i = 0; i < 1000; i++) {
            String str = romanNumerals[i];
            int sum = 0;
            boolean negative=false;
            for (int j = str.length() - 1; j >= 0; j--) {

                char x = str.charAt(j);
                if (j + 1 < str.length() && hash[x-65] < hash[str.charAt(j + 1)-65]) {
                    negative = true;
                }

                sum += ((negative) ? -hash[x - 65] : hash[x - 65]);
                negative = false;

            }

            String minimal=getRomanNumeral(sum);
            characterSaved+=str.length()-minimal.length();
        }

        return characterSaved;
    }

    private String getRomanNumeral(int num) {
        String val = "";
        if (num == 0) {
            return "";
        } else if (num == 4) {
            return "IV";
        } else if (num == 9) {
            return "IX";
        } else if (num >= 40 && num <= 49) {
            return "XL" + getRomanNumeral(num - 40);
        } else if (num >= 90 && num <= 99) {
            return "XC" + getRomanNumeral(num - 90);
        } else if (num >= 400 && num <= 499) {
            return "CD" + getRomanNumeral(num - 400);
        } else if (num >= 900 && num <= 999) {
            return "CM" + getRomanNumeral(num - 900);
        } else {
            for (int i = 0; i < A.length; i++) {
                if (num >= A[i]) {
                    int x = num / A[i];
                    while (x > 0) {
                        val += B[i];
                        x--;
                    }
                    num = num % A[i];
                    break;
                }
            }

            val += getRomanNumeral(num);
            return val;

        }

    }

}
