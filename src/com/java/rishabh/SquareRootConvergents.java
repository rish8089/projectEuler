package com.java.rishabh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SquareRootConvergents {

    public int getNoOfFractionsWhereNumeratorHasMoreDigitsThanDenominator() {
        List<Integer> initialFractionNumerator = new ArrayList<>();
        initialFractionNumerator.add(3);
        List<Integer> initialFractionDenominator = new ArrayList<>();
        initialFractionDenominator.add(2);

        int i = 2, ans = 0;
        List<Integer> nextFractionNumerator;
        List<Integer> nextFractionDenominator;

        while (i <= 1000) {
            nextFractionNumerator = addTwoLists(initialFractionNumerator, initialFractionDenominator);
            nextFractionDenominator=initialFractionDenominator;

            List<Integer> temp = nextFractionNumerator;
            nextFractionNumerator = nextFractionDenominator;
            nextFractionDenominator = temp;

            nextFractionNumerator = addTwoLists(nextFractionNumerator, nextFractionDenominator);

            if(nextFractionNumerator.size()>nextFractionDenominator.size())
                ans+=1;

            i++;
            initialFractionNumerator=nextFractionNumerator;
            initialFractionDenominator=nextFractionDenominator;
        }

        return ans;
    }

    private List<Integer> addTwoLists(List<Integer> digits, List<Integer> digitsInReverseOrder) {
        List<Integer> addedList = new ArrayList<>();

        int carry = 0;
        int i1= digits.size()-1;
        int i2=digitsInReverseOrder.size()-1;
        while(i1>=0 && i2>=0)
        {
            int sum = carry + digits.get(i1) + digitsInReverseOrder.get(i2);
            addedList.add(sum % 10);
            carry = sum / 10;

            i1--;
            i2--;
        }

        while(i1>=0)
        {
            int sum=carry+digits.get(i1);
            addedList.add(sum % 10);
            carry = sum / 10;

            i1--;
        }

        while(i2>=0)
        {
            int sum=carry+digitsInReverseOrder.get(i2);
            addedList.add(sum % 10);
            carry = sum / 10;

            i2--;
        }

        if(carry>0)
        {
            addedList.add(carry);
        }


        Collections.reverse(addedList);

        return addedList;
    }
}
