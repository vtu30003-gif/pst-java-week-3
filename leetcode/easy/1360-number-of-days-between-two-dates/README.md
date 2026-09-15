# Number of Days Between Two Dates

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Write a program to count the number of days between two dates.

The two dates are given as strings, their format is `YYYY-MM-DD` as shown in the examples.

 

 **Example 1:** 

```
Input: date1 = "2019-06-29", date2 = "2019-06-30"
Output: 1

```

 **Example 2:** 

```
Input: date1 = "2020-01-15", date2 = "2019-12-31"
Output: 15

```

 

 **Constraints:** 

- The given dates are valid dates between the years 1971 and 2100.

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 64.94%)  
**Memory:** 42.7 MB (beats 89.20%)  
**Submitted:** 2026-09-15T04:17:47.725Z  

```java
class Solution {
    private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysFrom1900(date1) - daysFrom1900(date2));
    }

    private int daysFrom1900(String date) {
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        int days = day;

        // Add days for previous years
        for (int y = 1900; y < year; y++) {
            days += isLeapYear(y) ? 366 : 365;
        }

        // Add days for previous months in the current year
        for (int m = 1; m < month; m++) {
            days += DAYS_IN_MONTH[m];
            if (m == 2 && isLeapYear(year)) {
                days += 1;
            }
        }

        return days;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/number-of-days-between-two-dates/)