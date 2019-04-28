package com.java.rishabh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ArithmeticExpressions {

    private List<List<Integer>> permutations;
    private List<Character> ops;
    private boolean visited[];
    private List<List<Integer>> paranthesis;

    ArithmeticExpressions() {
        permutations = new ArrayList<>();
        paranthesis = new ArrayList<>();
        paranthesis.add(Arrays.asList(0, 4, 6, 10));
        paranthesis.add(Arrays.asList(4, 8));
        paranthesis.add(Arrays.asList(0, 6));
        paranthesis.add(Arrays.asList(2, 8));
        paranthesis.add(Arrays.asList(0, 8));
        visited = new boolean[10];
        ops = new ArrayList<>();
        ops.add('*');
        ops.add('+');
        ops.add('-');
        ops.add('/');
    }

    public String getSetOfFourDigitsWithLongestSetOfConsecutivePositiveIntegers() {
        for (int i = 0; i <= 9; i++) {
            for (int j = i + 1; j <= 9; j++) {
                for (int k = j + 1; k <= 9; k++) {
                    for (int l = k + 1; l <= 9; l++) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        list.add(k);
                        list.add(l);
                        permutations.add(list);
                    }
                }
            }
        }

        String ans = "";
        int longest = 0;

        for (int i = 0; i < permutations.size(); i++) {

            HashSet<Integer> hashSet = new HashSet<>();
            for (int j = 0; j < paranthesis.size(); j++) {
                List<Integer> paranthesisPos = paranthesis.get(j);
                if (paranthesisPos.contains(0)) {
                    hashSet.addAll(
                        recurse(permutations.get(i), paranthesisPos, Mode.STACK, Mode.STACK, ' ',
                            ' ',
                            new Fraction(0, 1), new Fraction(0, 1), 0));
                } else {

                    List<Integer> permutation = permutations.get(i);
                    for (int k = 0; k < permutation.size(); k++) {

                        int num = permutation.get(k);

                        if (!visited[num]) {

                            Fraction temp = new Fraction(num, 1);
                            visited[num] = true;
                                hashSet.addAll(
                                    recurse(permutation, paranthesisPos, Mode.DIGIT, Mode.DIGIT,' ',' ',
                                        temp,new Fraction(0,1), 0));
                                visited[num] = false;
                            }
                        }
                    }
                }


            int nextNum=1;
            int cnt=0;
            List<Integer> list=new ArrayList<>(hashSet);
            Collections.sort(list);

            for(Integer element:list)
            {
                if(nextNum==element) {
                    cnt++;
                    nextNum++;
                }
                else
                    break;
            }

            if(longest<cnt)
            {
                longest=cnt;
                ans=""+permutations.get(i).get(0)+permutations.get(i).get(1)+permutations.get(i).get(2)+permutations.get(i).get(3);
            }
        }

        return ans;

    }

    private HashSet<Integer> recurse(List<Integer> permutation, List<Integer> paranthesisPos,
        Mode superMode, Mode subMode, char superOperator, char subOperator, Fraction expRes,
        Fraction stackRes, int idx) {

        HashSet<Integer> hashSet = new HashSet<>();

        if (idx == paranthesisPos.size() + 7) {
            if (expRes.n % expRes.d == 0) {
                if (expRes.n / expRes.d > 0) {
                    hashSet.add(expRes.n / expRes.d);
                }
            }
            return hashSet;
        }

        if (superMode.equals(Mode.STACK)) {
            if (subMode.equals(Mode.STACK)) {
                int pos = Collections.binarySearch(paranthesisPos, idx);
                if (pos >= 0) {
                    //found the idx in paranthesis positions
                    if (pos % 2 != 0) //its a closing bracket
                    {
                        Fraction temp = new Fraction(0, 0);
                        switch (superOperator) {

                            case ' ':
                            case '+':
                                temp.n = expRes.n * stackRes.d + stackRes.n * expRes.d;
                                temp.d = expRes.d * stackRes.d;
                                break;
                            case '*':
                                temp.n = expRes.n * stackRes.n;
                                temp.d = expRes.d * stackRes.d;
                                break;
                            case '-':
                                temp.n = expRes.n * stackRes.d - stackRes.n * expRes.d;
                                temp.d = expRes.d * stackRes.d;
                                break;
                            case '/':
                                if (stackRes.n != 0) {
                                    temp.n = expRes.n * stackRes.d;
                                    temp.d = expRes.d * stackRes.n;
                                }


                        }

                        if (temp.d != 0) {
                            //stack mode is over now
                            for (int i = 0; i < ops.size(); i++) {
                                hashSet
                                    .addAll(recurse(permutation, paranthesisPos, Mode.OP, Mode.OP,
                                        ops.get(i), ops.get(i), temp, new Fraction(0, 1),
                                        idx + 1));
                            }
                        }
                    } else //its a open bracket, next mode will be digit mode
                    {
                        //super mode will remain STACK
                        for (int i = 0; i < permutation.size(); i++) {

                            int num = permutation.get(i);

                            if (!visited[num]) {

                                Fraction temp = new Fraction(0, 0);

                                switch (subOperator) {
                                    case ' ':
                                    case '+':
                                        temp.n = stackRes.n + num * stackRes.d;
                                        temp.d = stackRes.d;
                                        break;
                                    case '*':
                                        temp.n = stackRes.n * num;
                                        temp.d = stackRes.d;
                                        break;
                                    case '-':
                                        temp.n = stackRes.n - num * stackRes.d;
                                        temp.d = stackRes.d;
                                        break;
                                    case '/':
                                        if (num != 0) {
                                            temp.n = stackRes.n;
                                            temp.d = stackRes.d * num;
                                        }


                                }

                                if (temp.d != 0) {
                                    visited[num] = true;
                                    hashSet.addAll(
                                        recurse(permutation, paranthesisPos, superMode, Mode.DIGIT,
                                            superOperator, subOperator,
                                            expRes, temp, idx + 1));
                                    visited[num] = false;
                                }
                            }
                        }
                    }
                }
            } else if (subMode.equals(Mode.DIGIT)) {
                if (paranthesisPos.contains(idx + 1)) //go to stack mode
                {
                    hashSet.addAll(
                        recurse(permutation, paranthesisPos, superMode, Mode.STACK, superOperator,
                            subOperator, expRes, stackRes, idx + 1));
                } else //go to op mode
                {
                    for (int i = 0; i < ops.size(); i++) {
                        hashSet.addAll(
                            recurse(permutation, paranthesisPos, superMode, Mode.OP, superOperator,
                                ops.get(i), expRes, stackRes, idx + 1));
                    }
                }
            } else {
                for (int i = 0; i < permutation.size(); i++) {

                    int num = permutation.get(i);

                    if (!visited[num]) {

                        Fraction temp = new Fraction(0, 0);

                        switch (subOperator) {
                            case ' ':
                            case '+':
                                temp.n = stackRes.n + num * stackRes.d;
                                temp.d = stackRes.d;
                                break;
                            case '*':
                                temp.n = stackRes.n * num;
                                temp.d = stackRes.d;
                                break;
                            case '-':
                                temp.n = stackRes.n - num * stackRes.d;
                                temp.d = stackRes.d;
                                break;
                            case '/':
                                if (num != 0) {
                                    temp.n = stackRes.n;
                                    temp.d = stackRes.d * num;
                                }


                        }

                        if (temp.d != 0) {
                            visited[num] = true;
                            hashSet.addAll(
                                recurse(permutation, paranthesisPos, superMode, Mode.DIGIT,
                                    superOperator, subOperator,
                                    expRes, temp, idx + 1));
                            visited[num] = false;
                        }
                    }
                }
            }

        } else if (superMode.equals(Mode.DIGIT)) {
            for (int i = 0; i < ops.size(); i++) {
                hashSet.addAll(
                    recurse(permutation, paranthesisPos, Mode.OP, Mode.OP, ops.get(i),
                        ops.get(i), expRes, stackRes, idx + 1));
            }
        } else {
            if (paranthesisPos.contains(idx + 1)) //go to stack mode
            {
                hashSet.addAll(
                    recurse(permutation, paranthesisPos, Mode.STACK, Mode.STACK, superOperator, ' ',
                        expRes, stackRes, idx + 1));
            } else {
                for (int i = 0; i < permutation.size(); i++) {

                    int num = permutation.get(i);

                    if (!visited[num]) {

                        Fraction temp = new Fraction(0, 0);

                        switch (subOperator) {
                            case ' ':
                            case '+':
                                temp.n = expRes.n + num * expRes.d;
                                temp.d = expRes.d;
                                break;
                            case '*':
                                temp.n = expRes.n * num;
                                temp.d = expRes.d;
                                break;
                            case '-':
                                temp.n = expRes.n - num * expRes.d;
                                temp.d = expRes.d;
                                break;
                            case '/':
                                if (num != 0) {
                                    temp.n = expRes.n;
                                    temp.d = expRes.d * num;
                                }


                        }

                        if (temp.d != 0) {
                            visited[num] = true;
                            hashSet.addAll(
                                recurse(permutation, paranthesisPos, Mode.DIGIT, Mode.DIGIT,
                                    superOperator, subOperator,
                                    temp, stackRes, idx + 1));
                            visited[num] = false;
                        }
                    }
                }
            }
        }

        return hashSet;


    }

    enum Mode {
        STACK,
        OP,
        DIGIT;
    }

    class Fraction {

        int n;
        int d;

        public Fraction(int n, int d) {
            this.n = n;
            this.d = d;
        }
    }


}
