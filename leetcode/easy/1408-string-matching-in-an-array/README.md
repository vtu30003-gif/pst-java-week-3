# String Matching in an Array

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an array of string `words`, return all strings in `words` that are a substring of another word. You can return the answer in  **any order**.

 

 **Example 1:** 

```
Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
["hero","as"] is also a valid answer.

```

 **Example 2:** 

```
Input: words = ["leetcode","et","code"]
Output: ["et","code"]
Explanation: "et", "code" are substring of "leetcode".

```

 **Example 3:** 

```
Input: words = ["blue","green","bu"]
Output: []
Explanation: No string of words is substring of another string.

```

 

 **Constraints:** 

- 1 <= words.length <= 100
- 1 <= words[i].length <= 30
- words[i] contains only lowercase English letters.
- All the strings of words are unique.

## Solution

**Language:** Java  
**Runtime:** 4 ms (beats 97.83%)  
**Memory:** 43.5 MB (beats 79.81%)  
**Submitted:** 2026-09-21T18:58:55.852Z  

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        int n = words.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Check if words[i] is a substring of words[j] (and not the same index)
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break; // Move to the next word once a match is found
                }
            }
        }

        return result;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/string-matching-in-an-array/)