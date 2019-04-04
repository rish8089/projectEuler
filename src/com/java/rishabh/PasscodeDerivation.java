package com.java.rishabh;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PasscodeDerivation {

    private int arr[];
    private int N = 50;
    private BufferedReader br;
    private int order[];
    private int inwardEdgesCount[];
    private List<List<Integer>> edges;

    PasscodeDerivation(BufferedReader br) {
        arr = new int[N];
        this.br = br;
        order = new int[10];
        inwardEdgesCount = new int[10];
        edges = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            edges.add(new ArrayList<>());
        }
    }

    public void processInput() throws IOException {
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    public void getShortestPossibleSecret() {

        Arrays.fill(order, 0);
        Arrays.fill(inwardEdgesCount, 0);
        for (int i = 0; i < edges.size(); i++) {
            edges.get(i).clear();
        }

        int a, b;

        for (int i = 0; i < N; i++) {
            List<Integer> digits = getDigits(arr[i]);

            for (int j = 0; j < digits.size() - 1; j++) {

                a = digits.get(j);
                b = digits.get(j + 1);
                inwardEdgesCount[b]+=1;

                List<Integer> adjacentVertices=edges.get(a);
                if(!adjacentVertices.contains(b))
                    adjacentVertices.add(b);

            }



        }

        for(int i=0;i<10;i++)
        {
            if(inwardEdgesCount[i]==0)
            {
                order[i]=1;
                dfs(i);
            }
        }

        for (int val : order) {
            System.out.println(val+" ");
        }


    }

    private void dfs(int a)
    {
        List<Integer> adjacentVertices=edges.get(a);

        for(int i=0;i<adjacentVertices.size();i++)
        {
            int b=adjacentVertices.get(i);
            //a->b
            if(1+order[a]>order[b] || order[b]==0)
            {
                order[b]=1+order[a];
                dfs(b);
            }

        }
    }

    private List<Integer> getDigits(int num) {
        List<Integer> digits = new ArrayList<>();

        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }

        Collections.reverse(digits);
        return digits;
    }

}
