package com.java.rishabh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ArithmeticExpressions {

    private List<List<Integer>> permutations;
    private List<Character> ops;
    private boolean visited[];

    ArithmeticExpressions() {
        permutations = new ArrayList<>();
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
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            HashSet<Integer> ret = recurse(permutations.get(i), 0, '+', 0);
            List<Integer> list = new ArrayList<>(ret);
            Collections.sort(list);
            int cnt = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == j + 1) {
                    cnt += 1;
                } else {
                    break;
                }
            }

            if (longest < cnt) {
                longest = cnt;
                ans = "";
                ans = ans + permutations.get(i).get(0) + permutations.get(i).get(1) + permutations
                    .get(i)
                    .get(2) + permutations.get(i).get(3);
            }

        }

        return ans;

    }

    private HashSet<Integer> recurse(List<Integer> permutation, int opMode, char operator,
        int res) {
        HashSet<Integer> hashSet = new HashSet<>();
        int temp = 0;
        if (opMode % 2 == 0) {
            //its not op mode, its digit mode
            for (int i = 0; i < permutation.size(); i++) {
                int num = permutation.get(i);
                if (!visited[num]) {

                    boolean flag = false;
                    switch (operator) {
                        case '+':
                            temp = res + num;
                            flag = true;
                            break;
                        case '-':
                            temp = res - num;
                            flag = true;
                            break;
                        case '*':
                            temp = res * num;
                            flag = true;
                            break;
                        case '/':
                            if (num != 0 && res % num == 0) {
                                flag = true;
                                temp = res / num;
                            }

                    }
                    if (flag) {
                        visited[num] = true;
                        HashSet<Integer> ret = recurse(permutation, opMode + 1, operator, temp);
                        hashSet.addAll(ret);
                        visited[num] = false;
                    }

                }
            }
        } else {
            if (opMode == 7) {
                if (res > 0) {
                    hashSet.add(res);
                }
            } else {
                for (int i = 0; i < ops.size(); i++) {
                    HashSet<Integer> ret = recurse(permutation, opMode + 1, ops.get(i), res);
                    hashSet.addAll(ret);
                }
            }
        }

        return hashSet;

    }
}
