# Largest Number

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a list of non-negative integers `nums`, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.

 

 **Example 1:** 

```
Input: nums = [10,2]
Output: "210"

```

 **Example 2:** 

```
Input: nums = [3,30,34,5,9]
Output: "9534330"

```

 

 **Constraints:** 

- 1 <= nums.length <= 100
- 0 <= nums[i] <= 109

## Solution

**Language:** Java  
**Runtime:** 6 ms (beats 93.18%)  
**Memory:** 45 MB (beats 61.23%)  
**Submitted:** 2026-09-15T04:24:04.238Z  

```java
import java.util.Arrays;

public class Solution {
    public String largestNumber(int[] nums) {
        // 1. Convert integers to string representations
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // 2. Custom sort based on concatenation comparison
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

        // 3. Edge case: if highest value is "0", result is "0"
        if (strs[0].equals("0")) {
            return "0";
        }

        // 4. Combine sorted strings
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }

        return sb.toString();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/largest-number/)