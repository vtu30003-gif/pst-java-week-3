import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int ast : asteroids) {
            boolean exploded = false;

            // Collision only happens if stack top moves right (+) and current moves left (-)
            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                if (stack.peek() < -ast) {
                    stack.pop(); // Top explodes, keep checking current
                } else if (stack.peek() == -ast) {
                    stack.pop(); // Both explode
                    exploded = true;
                    break;
                } else {
                    exploded = true; // Current explodes
                    break;
                }
            }

            if (!exploded) {
                stack.push(ast);
            }
        }

        // Convert stack to result array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}