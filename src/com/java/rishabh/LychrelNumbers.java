package com.java.rishabh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LychrelNumbers {

    int lim = 10000;

    public int getCountOfLychrelNumbers() {
        int ans=0;

        for (int i = 1; i < lim; i++) {


            boolean flag=false;
            int cnt=1;

            List<Integer> digits = new ArrayList<>();
            String str = String.valueOf(i);
            for (int j = 0; j < str.length(); j++) {
                digits.add(str.charAt(j) - 48);
            }

            while (cnt<50) {

                List<Integer> digitsInReverseOrder = getListInReverseOrder(digits);

                List<Integer> addedList = addTwoLists(digits, digitsInReverseOrder);

                if(checkIfListIsPalindrome(addedList)) {
                    flag=true;
                    break;
                }

                digits=addedList;
                cnt++;

            }

            if(!flag)
            {
                ans+=1;
            }


        }

        return ans;
    }

    private List<Integer> getListInReverseOrder(List<Integer> digits) {
        List<Integer> digitsInReverseOrder = new ArrayList<>(digits.size());


        digits.forEach(digit->{
            digitsInReverseOrder.add(digit);
        });
        Collections.reverse(digitsInReverseOrder);

        return digitsInReverseOrder;
    }

    private List<Integer> addTwoLists(List<Integer> digits, List<Integer> digitsInReverseOrder) {
        List<Integer> addedList = new ArrayList<>();

        int carry=0;
        for (int i = digits.size()-1; i>=0; i--) {
            int sum=carry+digits.get(i)+digitsInReverseOrder.get(i);
            addedList.add(sum%10);
            carry=sum/10;
        }

        if(carry>0)
            addedList.add(carry);

        Collections.reverse(addedList);

        return addedList;
    }

    private boolean checkIfListIsPalindrome(List<Integer> list) {
        boolean flag = true;
        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i) != list.get(list.size() - 1 - i)) {
                flag = false;
                break;
            }
        }

        return flag;

    }


}
