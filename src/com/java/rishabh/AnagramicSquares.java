package com.java.rishabh;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;


public class AnagramicSquares {

    private BufferedReader br;
    private String words[];
    private List<List<Long>> squares;
    private HashMap<String, List<String>> anagramPairsHashMap;
    private HashMap<String, Integer> visited;
    int lim = 2000;

    AnagramicSquares(BufferedReader br) {
        this.br = br;
        squares = new ArrayList<>();
        anagramPairsHashMap = new HashMap<>();
        visited = new HashMap<>();

    }

    public void processInput() throws IOException {
        words = br.readLine().split(",");
    }

    public long getLargestSquareFormed() {
        int maxLen = 0;
        for (int i = 0; i < words.length; i++) {
            if (maxLen < words[i].length() - 2) {
                maxLen = words[i].length() - 2;
            }

        }

        long num = 1, tempLim;
        for (int i = 1; i <= maxLen; i++) {
            tempLim = (long) Math.pow(10, i);
            List<Long> newList = new ArrayList<>();
            squares.add(newList);
            while (num * num < tempLim) {
                newList.add(num * num);
                num++;
            }
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited.containsKey(words[i])) {
                visited.put(words[i], 1);
                List<String> newList = new ArrayList<>();
                newList.add(words[i]);
                anagramPairsHashMap.put(words[i], newList);

                for (int j = 0; j < words.length; j++) {
                    if (!visited.containsKey(words[j])) {
                        if (isPermutation(words[i], words[j])) {
                            visited.put(words[j], 1);
                            newList.add(words[j]);
                        }
                    }
                }
            }
        }

        Set<String> keys = anagramPairsHashMap.keySet();
        long ans = 0;

        for (String key : keys) {
            List<String> anagrams = anagramPairsHashMap.get(key);
            if (anagrams.size() > 1) {
                int len = key.length();
                List<Long> squaresOfLengthLen = squares.get(len - 3);

                for (int i = 0; i < anagrams.size(); i++) {
                    for (Long square : squaresOfLengthLen) {
                        if (isValidSquare(anagrams.get(i), square)) {
                            for (int j = i+1; j < anagrams.size(); j++) {

                                    //for (String anagram : anagrams) {
                                    long ret = isAnagramicSquare(anagrams.get(i), anagrams.get(j), square);
                                    if (ret != -1) {
                                        long max = square > ret ? square : ret;
                                        if (ans < max) {

                                            ans = max;
                                        }
                                    }
                                    //}
                                }
                        }
                    }
                }


            }
        }

        return ans;
    }

    private boolean isPermutation(String str1, String str2) {
        int hash[] = new int[26];
        for (int i = 1; i < str1.length() - 1; i++) {
            hash[str1.charAt(i) - 'A']++;
        }

        for (int i = 1; i < str2.length() - 1; i++) {
            hash[str2.charAt(i) - 'A']--;
        }

        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidSquare(String str, long square) {
        int i = str.length() - 2;
        int hash1[] = new int[26]; //for alphabets
        int hash2[] = new int[10];//for digits
        Arrays.fill(hash1, -1);
        Arrays.fill(hash2, -1);
        while (square > 0) {
            int x = (int) (square % 10);
            square = square / 10;

            if (hash2[x] == -1) //number x didn't come before
            {
                if (hash1[str.charAt(i) - 'A'] == -1) {
                    hash2[x] = str.charAt(i) - 'A'; //x is mapped to str.charAt(i)-'A'
                    hash1[str.charAt(i) - 'A'] = x;
                } else //str.charAt(i)-'A' is already mapped
                {
                    return false;
                }
            } else {
                if (hash2[x] != str.charAt(i) - 'A') {
                    return false;
                }
            }
            i--;

        }

        return true;
    }

    private long isAnagramicSquare(String str1, String str2, long square) {
        int i = str1.length() - 2;
        int hash[] = new int[26];

        while (square > 0) {
            int x = (int) (square % 10);
            hash[str1.charAt(i) - 'A'] = x;
            square /= 10;
            i--;
        }

        long num = 0;
        for (i = 1; i < str2.length() - 1; i++) {
            if(i==1 && hash[str2.charAt(i) - 'A']==0)
                return -1;
            else
            num = num * 10 + hash[str2.charAt(i) - 'A'];
        }

        if (isPerfectSquare(num)) {
            return num;
        } else {
            return -1;
        }


    }

    private boolean isPerfectSquare(long num) {
        long sqrt = (long) (Math.sqrt(num));
        return sqrt * sqrt == num;

    }


}
