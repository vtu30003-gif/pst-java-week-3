# Implement Queue using Stacks

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (`push`, `peek`, `pop`, and `empty`).

Implement the `MyQueue` class:

- void push(int x) Pushes element x to the back of the queue.
- int pop() Removes the element from the front of the queue and returns it.
- int peek() Returns the element at the front of the queue.
- boolean empty() Returns true if the queue is empty, false otherwise.

 **Notes:** 

- You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
- Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.

 

 **Example 1:** 

```
Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]

Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false

```

 

 **Constraints:** 

- 1 <= x <= 9
- At most 100 calls will be made to push, pop, peek, and empty.
- All the calls to pop and peek are valid.

 

 **Follow-up:**  Can you implement the queue such that each operation is  **amortized**  `O(1)` time complexity? In other words, performing `n` operations will take overall `O(n)` time even if one of those operations may take longer.

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 42.6 MB (beats 84.62%)  
**Submitted:** 2026-09-15T09:26:59.115Z  

```java
import java.util.Stack;

class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }
    
    // Push element x to the back of queue.
    public void push(int x) {
        inStack.push(x);
    }
    
    // Removes the element from the front of queue and returns it.
    public int pop() {
        moveInToOut();
        return outStack.pop();
    }
    
    // Get the front element.
    public int peek() {
        moveInToOut();
        return outStack.peek();
    }
    
    // Returns whether the queue is empty.
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    // Helper method to transfer elements when outStack is empty
    private void moveInToOut() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/implement-queue-using-stacks/)