# Day of the Week

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a date, return the corresponding day of the week for that date.

The input is given as three integers representing the `day`, `month` and `year` respectively.

Return the answer as one of the following values `{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}`.

 **Note:**  January 1, 1971 was a Friday.

 

 **Example 1:** 

```
Input: day = 31, month = 8, year = 2019
Output: "Saturday"

```

 **Example 2:** 

```
Input: day = 18, month = 7, year = 1999
Output: "Sunday"

```

 **Example 3:** 

```
Input: day = 15, month = 8, year = 1993
Output: "Sunday"

```

 

 **Constraints:** 

- The given dates are valid dates between the years 1971 and 2100.

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 42.8 MB (beats 16.42%)  
**Submitted:** 2026-09-15T04:19:22.330Z  

```java
class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int totalDays = 0;
        
        // 1. Add days for all past years since 1971
        for (int i = 1971; i < year; i++) {
            if (isLeapYear(i)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
        }
        
        // 2. Add days for past months in the current year
        for (int i = 0; i < month - 1; i++) {
            if (i == 1 && isLeapYear(year)) {
                totalDays += 29;
            } else {
                totalDays += months[i];
            }
        }
        
        // 3. Add days in the current month
        totalDays += (day - 1);
        
        // Modulo 7 maps directly to the days array starting at Friday (index 0)
        return days[totalDays % 7];
    }
    
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/day-of-the-week/)