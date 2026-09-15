# Min Stack

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the `MinStack` class:

- MinStack() initializes the stack object.
- void push(int value) pushes the element value onto the stack.
- void pop() removes the element on the top of the stack.
- int top() gets the top element of the stack.
- int getMin() retrieves the minimum element in the stack.

You must implement a solution with `O(1)` time complexity for each function.

 

 **Example 1:** 

```
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2

```

 

 **Constraints:** 

- -231 <= val <= 231 - 1
- Methods pop, top and getMin operations will always be called on non-empty stacks.
- At most 3 * 104 calls will be made to push, pop, top, and getMin.

## Solution

**Language:** Java  
**Runtime:** 35 ms (beats 40.14%)  
**Memory:** 99.4 MB (beats 95.52%)  
**Submitted:** 2026-09-15T09:18:49.966Z  

```java
import java.util.Stack;

class MinStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        mainStack.push(val);
        // Push to minStack if empty or val is <= current minimum
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        // If popping the minimum value, pop from minStack as well
        if (mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        mainStack.pop();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/min-stack/)