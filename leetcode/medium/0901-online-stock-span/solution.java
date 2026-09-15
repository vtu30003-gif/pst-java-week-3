import java.util.ArrayDeque;
import java.util.Deque;

class StockSpanner {
    // Stack stores pairs: [price, span]
    private Deque<int[]> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int span = 1;
        
        // Accumulate spans of all previous days with prices <= current price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        
        stack.push(new int[]{price, span});
        return span;
    }
}