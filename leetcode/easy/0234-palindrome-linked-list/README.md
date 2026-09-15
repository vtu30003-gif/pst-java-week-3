# Palindrome Linked List

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given the `head` of a singly linked list, return `true` *if it is a  **palindrome**  or* `false` *otherwise*.

 

 **Example 1:** 

```
Input: head = [1,2,2,1]
Output: true

```

 **Example 2:** 

```
Input: head = [1,2]
Output: false

```

 

 **Constraints:** 

- The number of nodes in the list is in the range [1, 105].
- 0 <= Node.val <= 9

 

 **Follow up:**  Could you do it in `O(n)` time and `O(1)` space?

## Solution

**Language:** Java  
**Runtime:** 4 ms (beats 67.21%)  
**Memory:** 96.9 MB (beats 25.84%)  
**Submitted:** 2026-09-15T09:02:35.849Z  

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 1. Find middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half of the list
        ListNode secondHalfHead = reverseList(slow);

        // 3. Compare first half and reversed second half
        ListNode firstHalfHead = head;
        ListNode p2 = secondHalfHead;
        boolean isPalindrome = true;

        while (p2 != null) {
            if (firstHalfHead.val != p2.val) {
                isPalindrome = false;
                break;
            }
            firstHalfHead = firstHalfHead.next;
            p2 = p2.next;
        }

        // (Optional) 4. Restore the original list structure
        reverseList(secondHalfHead);

        return isPalindrome;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/palindrome-linked-list/)