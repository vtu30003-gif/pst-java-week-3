import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0; // Pointer for popped array
        
        for (int val : pushed) {
            stack.push(val);
            
            // Pop while top of stack matches current popped element
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        
        return stack.isEmpty();
    }
}