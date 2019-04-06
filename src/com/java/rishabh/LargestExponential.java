package com.java.rishabh;


import java.io.BufferedReader;
import java.io.IOException;

public class LargestExponential {

    int lim=1000;
    private BufferedReader br;
    Node arr[];

    LargestExponential(BufferedReader br)
    {
        this.br=br;
        arr=new Node[lim];
    }

    public void processInput() throws IOException {
        for(int i=0;i<lim;i++)
        {
            String str[]=br.readLine().split(",");
            Node node=new Node();
            node.setBase(Integer.parseInt(str[0]));
            node.setExp(Integer.parseInt(str[1]));
            arr[i]=node;
        }
    }

    public int getIndexWithLargestValue()
    {
        int pos=-1;
        Node largestNode=new Node();
        largestNode.setBase(-1);

        for(int i=0;i<lim;i++)
        {
            if(largestNode.getBase()==-1)
            {
                largestNode.setBase(arr[i].getBase());
                largestNode.setExp(arr[i].getExp());
                pos=i;
            }

            else
            {
                double node1Val=largestNode.getExp();
                double node2Val=arr[i].exp*Math.log(arr[i].base)/Math.log(largestNode.base);
                if(node1Val<node2Val)
                {
                    largestNode.setBase(arr[i].getBase());
                    largestNode.setExp(arr[i].getExp());
                    pos=i;
                }
            }
        }

        return pos+1;

    }



    class Node
    {
        int base;
        int exp;

        public int getBase() {
            return base;
        }

        public void setBase(int base) {
            this.base = base;
        }

        public int getExp() {
            return exp;
        }

        public void setExp(int exp) {
            this.exp = exp;
        }
    }

}
