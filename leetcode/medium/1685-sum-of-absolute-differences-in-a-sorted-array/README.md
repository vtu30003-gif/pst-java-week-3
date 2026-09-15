# Sum of Absolute Differences in a Sorted Array

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an integer array `nums` sorted in  **non-decreasing**  order.

Build and return  *an integer array* `result` *with the same length as* `nums` *such that* `result[i]` *is equal to the  **summation of absolute differences**  between* `nums[i]` *and all the other elements in the array.* 

In other words, `result[i]` is equal to `sum(|nums[i]-nums[j]|)` where `0 <= j < nums.length` and `j != i` (**0-indexed**).

 

 **Example 1:** 

```
Input: nums = [2,3,5]
Output: [4,3,5]
Explanation: Assuming the arrays are 0-indexed, then
result[0] = |2-2| + |2-3| + |2-5| = 0 + 1 + 3 = 4,
result[1] = |3-2| + |3-3| + |3-5| = 1 + 0 + 2 = 3,
result[2] = |5-2| + |5-3| + |5-5| = 3 + 2 + 0 = 5.

```

 **Example 2:** 

```
Input: nums = [1,4,6,8,10]
Output: [24,15,13,15,21]

```

 

 **Constraints:** 

- 2 <= nums.length <= 105
- 1 <= nums[i] <= nums[i + 1] <= 104

## Solution

**Language:** Java  
**Runtime:** 4 ms (beats 82.22%)  
**Memory:** 85.3 MB (beats 82.22%)  
**Submitted:** 2026-09-15T08:49:51.127Z  

```java
class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        int[] result = new int[n];
        int leftSum = 0;
        
        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            
            int leftPart = i * nums[i] - leftSum;
            int rightPart = rightSum - (n - 1 - i) * nums[i];
            
            result[i] = leftPart + rightPart;
            
            leftSum += nums[i];
        }
        
        return result;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/)