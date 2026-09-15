# Day of the Year

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a string `date` representing a Gregorian calendar date formatted as `YYYY-MM-DD`, return  *the day number of the year*.

 

 **Example 1:** 

```
Input: date = "2019-01-09"
Output: 9
Explanation: Given date is the 9th day of the year in 2019.

```

 **Example 2:** 

```
Input: date = "2019-02-10"
Output: 41

```

 

 **Constraints:** 

- date.length == 10
- date[4] == date[7] == '-', and all other date[i]'s are digits
- date represents a calendar date between Jan 1st, 1900 and Dec 31st, 2019.

## Solution

**Language:** Java  
**Runtime:** 8 ms (beats 37.33%)  
**Memory:** 46.9 MB (beats 78.97%)  
**Submitted:** 2026-09-15T04:18:34.462Z  

```java
class Solution {
    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Check for leap year
        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }

        int dayCount = day;
        for (int i = 0; i < month - 1; i++) {
            dayCount += daysInMonth[i];
        }

        return dayCount;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/day-of-the-year/)