# Find and Replace Pattern

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a list of strings `words` and a string `pattern`, return  *a list of*  `words[i]`  *that match*  `pattern`. You may return the answer in  **any order**.

A word matches the pattern if there exists a permutation of letters `p` so that after replacing every letter `x` in the pattern with `p(x)`, we get the desired word.

Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.

 

 **Example 1:** 

```
Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e,...}. 
"ccc" does not match the pattern because {a -> c, b -> c,...} is not a permutation, since a and b map to the same letter.

```

 **Example 2:** 

```
Input: words = ["a","b","c"], pattern = "a"
Output: ["a","b","c"]

```

 

 **Constraints:** 

- 1 <= pattern.length <= 20
- 1 <= words.length <= 50
- words[i].length == pattern.length
- pattern and words[i] are lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 43.6 MB (beats 86.37%)  
**Submitted:** 2026-09-21T18:57:44.676Z  

```java
import java.util.*;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }
        
        return result;
    }
    
    private boolean matches(String word, String pattern) {
        int[] pToW = new int[26];
        int[] wToP = new int[26];
        
        for (int i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            char w = word.charAt(i);
            
            // Map 1-indexed to distinguish unmapped (0) from mapped positions
            if (pToW[p - 'a'] == 0 && wToP[w - 'a'] == 0) {
                pToW[p - 'a'] = w - 'a' + 1;
                wToP[w - 'a'] = p - 'a' + 1;
            } else if (pToW[p - 'a'] != w - 'a' + 1 || wToP[w - 'a'] != p - 'a' + 1) {
                return false;
            }
        }
        
        return true;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/find-and-replace-pattern/)