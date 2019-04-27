package com.java.rishabh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ProductSumNumbers {

    int K[];
    int lim = 12000;
    List<List<Integer>> computations;

    ProductSumNumbers() {
        K = new int[lim + 1];
        computations = new ArrayList<>();
    }

    public long getMinimalProductSumNumbers() {
        long sum = 0;

        int i = 1;
        int cnt = 0;
        while (cnt != lim - 1) {
            List<Integer> list = new ArrayList<>();
            computations.add(list);
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    int a = j;
                    int b = i / j;
                    if (a * b >= a + b) {
                        int diff = a * b - (a + b);
                        if (diff + 2 <= lim) {
                            if (K[2 + diff] == 0) {
                                K[2 + diff] = i;

                                //System.out.println(2+diff);
                                cnt += 1;
                            }
                            list.add(2 + diff);
                        }

                        List<Integer> prevList = computations.get(b - 1);
                        for (int l = 0; l < prevList.size(); l++) {
                            int element = prevList.get(l);
                            if (diff + 1 + element <= lim) {
                                if (K[diff + 1 + element] == 0) {
                                    K[diff + 1 + element] = i;
                                    cnt += 1;
                                }
                                list.add(diff + 1 + element);

                            }
                        }

                        prevList = computations.get(a - 1);
                        for (int l = 0; l < prevList.size(); l++) {
                            int element = prevList.get(l);
                            if (diff + 1 + element <= lim) {
                                if (K[diff + 1 + element] == 0) {
                                    K[diff + 1 + element] = i;

                                    cnt += 1;
                                }
                                list.add(diff + 1 + element);
                            }
                        }

                        prevList = computations.get(a - 1);
                        List<Integer> prevList1 = computations.get(b - 1);
                        for (int l = 0; l < prevList.size(); l++) {
                            int element1 = prevList.get(l);
                            for (int q = 0; q < prevList1.size(); q++) {
                                int element2 = prevList1.get(q);
                                if (element1 + element2 + diff <= lim) {
                                    if (K[diff + element1 + element2] == 0) {
                                        K[element1 + element2 + diff] = i;

                                        cnt += 1;
                                    }
                                    list.add(element1 + element2 + diff);
                                }
                            }
                        }


                    }

                }
            }
            i++;
        }

        HashSet<Integer> hashSet=new HashSet<>();

        for (i = 2; i <= lim; i++) {
            if(!hashSet.contains(K[i]))
            {
                sum=sum+K[i];
                hashSet.add(K[i]);
            }
        }

        return sum;
    }

}
