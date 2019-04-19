package com.java.rishabh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Magic5gonRing {

    int lim = 10;
    boolean visited[];

    Magic5gonRing() {
        visited = new boolean[lim + 1];
    }

    public void getMaximum16DigitString() {

        int lowestSum = 6;
        int highestSum = lim + lim - 1 + lim - 2;
        String ans="";

        for (int i = lowestSum; i <= highestSum; i++) {
            Arrays.fill(visited, false);
            String ret =
                recurse(i, true, 0, 0, new ArrayList<>(), new ArrayList<>());
            if(ret.compareTo(ans)>0)
                ans=ret;
        }

        System.out.println("ans = " + ans);
    }

    private String recurse(int sum, boolean externalMode, int internalNodeIdx, int externalNodeIdx,
        List<Integer> externalNodes, List<Integer> internalNodes) {

        String ans = "", ret;

        if (externalMode) {
            if (externalNodeIdx == lim / 2) {
                //some logic to return the 16 digit string
                String temp = "";
                for (int i = 0; i < externalNodes.size(); i++) {
                    temp = temp + externalNodes.get(i) + internalNodes.get(i) + internalNodes
                        .get((i + 1) % (lim / 2));
                }
                return temp;
            }

            for (int i = 1; i <= lim; i++) {
                if (!visited[i]) //not visited
                {
                    if (externalNodeIdx == 0 || i > externalNodes.get(0)) {
                        if (externalNodeIdx < internalNodes.size()) {
                            if ((externalNodeIdx + 1) % (lim / 2) < internalNodes.size()) {

                                int tempSum = i + internalNodes.get(externalNodeIdx) + internalNodes
                                    .get((externalNodeIdx + 1) % (lim / 2));
                                if (tempSum == sum) {
                                    visited[i] = true;
                                    externalNodes.add(i);
                                    ret = recurse(sum, true, externalNodeIdx + 1,
                                        externalNodeIdx + 1,
                                        externalNodes, internalNodes);
                                    if (ret.compareTo(ans) > 0) {
                                        ans = ret;
                                    }
                                    visited[i] = false;
                                    externalNodes.remove(externalNodeIdx);
                                } else if (tempSum > sum) {
                                    break;
                                }

                            } else {
                                int remainingSum = sum - i - internalNodes.get(externalNodeIdx);

                                if (remainingSum <= 0) {
                                    break;
                                } else if (remainingSum <= lim && !visited[remainingSum]
                                    && remainingSum != i) {
                                    //solution is reachable
                                    visited[i] = true;
                                    externalNodes.add(i);
                                    ret = recurse(sum, false, externalNodeIdx + 1, externalNodeIdx,
                                        externalNodes, internalNodes);
                                    if (ret.compareTo(ans) > 0) {
                                        ans = ret;
                                    }
                                    visited[i] = false;
                                    externalNodes.remove(externalNodeIdx);
                                }

                            }
                        } else {
                            int remainingSum = sum - i;
                            if (remainingSum <= 0) {
                                break;
                            } else {
                                visited[i] = true;
                                externalNodes.add(i);
                                ret = recurse(sum, false, externalNodeIdx, externalNodeIdx,
                                    externalNodes,
                                    internalNodes);
                                if (ret.compareTo(ans) > 0) {
                                    ans = ret;
                                }
                                visited[i] = false;
                                externalNodes.remove(externalNodeIdx);
                            }

                        }

                    }
                }
            }

        } else {
            for (int i = 1; i <= lim; i++) {
                if (!visited[i] && i != 10) {
                    if (internalNodeIdx == externalNodeIdx) {
                        int remainingSum = sum - i - externalNodes.get(externalNodeIdx);
                        if (remainingSum <= 0) {
                            break;
                        } else if (remainingSum <= lim && !visited[remainingSum]
                            && remainingSum != i) {
                            visited[i] = true;
                            internalNodes.add(i);
                            ret = recurse(sum, false, internalNodeIdx + 1, externalNodeIdx,
                                externalNodes,
                                internalNodes);
                            if (ret.compareTo(ans) > 0) {
                                ans = ret;
                            }
                            visited[i] = false;
                            internalNodes.remove(internalNodeIdx);
                        }
                    } else {
                        int tempSum = externalNodes.get(externalNodeIdx) + internalNodes
                            .get(internalNodeIdx - 1) + i;

                        if (tempSum == sum) {
                            visited[i] = true;
                            internalNodes.add(i);
                            ret = recurse(sum, true, externalNodeIdx + 1, externalNodeIdx + 1,
                                externalNodes, internalNodes);
                            if (ret.compareTo(ans) > 0) {
                                ans = ret;
                            }
                            visited[i] = false;
                            internalNodes.remove(internalNodeIdx);
                        }

                    }
                }
            }
        }

        return ans;

    }


}
