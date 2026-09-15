# Minimum Remove to Make Valid Parentheses

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string s of `'('`, `')'` and lowercase English characters.

Your task is to remove the minimum number of parentheses (`'('` or `')'`, in any positions) so that the resulting  *parentheses string*  is valid and return  **any**  valid string.

Formally, a  *parentheses string*  is valid if and only if:

- It is the empty string, contains only lowercase characters, or
- It can be written as AB (A concatenated with B), where A and B are valid strings, or
- It can be written as (A), where A is a valid string.

 

 **Example 1:** 

```
Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)", "lee(t(c)ode)" would also be accepted.

```

 **Example 2:** 

```
Input: s = "a)b(c)d"
Output: "ab(c)d"

```

 **Example 3:** 

```
Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.

```

 

 **Constraints:** 

- 1 <= s.length <= 105
- s[i] is either '(', ')', or lowercase English letter.

## Solution

**Language:** Java  
**Runtime:** 19 ms (beats 59.33%)  
**Memory:** 47.2 MB (beats 63.74%)  
**Submitted:** 2026-09-15T09:18:11.686Z  

```java
import java.util.*;

class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexesToRemove = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();

        // Identify unmatched '(' and ')'
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    indexesToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        // Add remaining unmatched '(' indices
        while (!stack.isEmpty()) {
            indexesToRemove.add(stack.pop());
        }

        // Build valid result string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexesToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/)