package com.java.rishabh;

public class CountingSundays {

    int hash_NonLeapYear[][];
    int hash_LeapYear[][];
    int days_in_month_NonLeapYear[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int days_in_month_LeapYear[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    CountingSundays() {
        hash_NonLeapYear = new int[7][7];
        hash_LeapYear = new int[7][7];

    }

    public int getNoOfSundays() {
        //for non-leap year

        int curr_day_week_index;

        for (int i = 0; i < 7; i++) {

            curr_day_week_index = i;

            hash_NonLeapYear[i][i] = 1;

            for (int j = 0; j < 11; j++) {
                curr_day_week_index = (curr_day_week_index + days_in_month_NonLeapYear[j]) % 7;
                hash_NonLeapYear[i][curr_day_week_index]++;

            }

        }

        //for leap year

        for (int i = 0; i < 7; i++) {

            curr_day_week_index = i;

            hash_LeapYear[i][i] = 1;

            for (int j = 0; j < 11; j++) {
                curr_day_week_index = (curr_day_week_index + days_in_month_LeapYear[j]) % 7;
                hash_LeapYear[i][curr_day_week_index]++;

            }

        }

        int current_year_first_day_week_index = 1; //current year is 1900
        int total = 0;

        for (int i = 1901; i <= 2000; i++) {
            if (isLeapYear(i - 1)) {
                current_year_first_day_week_index = (current_year_first_day_week_index + 2) % 7;
            } else {
                current_year_first_day_week_index = (current_year_first_day_week_index + 1) % 7;
            }

            if (isLeapYear(i)) {
                total += hash_LeapYear[current_year_first_day_week_index][0];
            } else {
                total += hash_NonLeapYear[current_year_first_day_week_index][0];
            }

        }

        return total;


    }

    boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0 && year % 400 != 0) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

}


