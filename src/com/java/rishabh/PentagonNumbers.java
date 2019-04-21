package com.java.rishabh;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;

public class PentagonNumbers {

    private PriorityQueue<HeapNode> pq;
    private HashSet<HeapNode> hashSet;

    PentagonNumbers() {
        pq = new PriorityQueue<>(new HeapNodeComparator());
        hashSet=new HashSet<>();
    }

    public long getMinimalD() {
        long diff, sum;
        HeapNode initialNode=new HeapNode(1, 1);
        pq.add(initialNode);
        hashSet.add(initialNode);
        while (!pq.isEmpty()) {
            HeapNode node = pq.poll();
            hashSet.remove(node);
            diff = 3 * node.x * node.y + getPentagonalNumber(node.x);
            sum = 2 * getPentagonalNumber(node.y) + diff;

            if (isPentagonalNumber(diff) && isPentagonalNumber(sum)) {
                System.out.println(node.y+" "+(node.y+node.x));
                System.out.println(diff+" "+sum);
                return diff;
            }

            if (!hashSet.contains(new HeapNode(node.x + 1, node.y))) {
                HeapNode newNode=new HeapNode(node.x + 1, node.y);
                pq.add(newNode);
                hashSet.add(newNode);
            }

            if (!hashSet.contains(new HeapNode(node.x, node.y + 1))) {
                HeapNode newNode=new HeapNode(node.x, node.y+1);
                pq.add(newNode);
                hashSet.add(newNode);
            }

        }

        return -1;
    }

    private long getPentagonalNumber(long n) {
        return n * (3 * n - 1) / 2;
    }

    private class HeapNode {

        int x;
        int y;

        public HeapNode(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            HeapNode node = (HeapNode) o;
            return x == node.x &&
                y == node.y;
        }

        @Override
        public int hashCode() {

            return Objects.hash(x, y);
        }
    }

    class HeapNodeComparator implements Comparator<HeapNode> {

        @Override
        public int compare(HeapNode node1, HeapNode node2) {
            long node1Val = 3 * node1.x * node1.y + getPentagonalNumber(node1.x);
            long node2Val = 3 * node2.x * node2.y + getPentagonalNumber(node2.x);

            if (node1Val < node2Val) {
                return -1;
            } else if (node1Val > node2Val) {
                return 1;
            }

            return 0;
        }
    }

    private boolean isPentagonalNumber(long num) {
        long sqrt = (long) Math.sqrt(1 + 24 * num);
        if (sqrt * sqrt == 1 + 24 * num && (1 + sqrt) % 6 == 0) {
            return true;
        } else {
            return false;
        }
    }

}
