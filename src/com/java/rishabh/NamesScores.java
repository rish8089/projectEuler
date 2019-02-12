package com.java.rishabh;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class NamesScores {

    BufferedReader br;
    String str;

    NamesScores(BufferedReader br)
    {
        this.br=br;
    }

    public void processInput() throws IOException {
        this.str=br.readLine();
    }

    public int getTotalNameScores()
    {
        String words[]=str.split(",");

        Arrays.sort(words);

        int total=0;

        for(int i=0;i<words.length;i++)
        {
            total=total+getAlphabeticalValue(words[i])*(i+1);
        }
        return total;
    }

    private int getAlphabeticalValue(String s)
    {
        int val=0;
        for(int i=1;i<s.length()-1;i++)
        {
            val+=s.charAt(i)-'A'+1;
        }
        return val;
    }

}
