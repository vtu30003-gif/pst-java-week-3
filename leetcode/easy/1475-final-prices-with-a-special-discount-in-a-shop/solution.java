class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = prices.clone();
        // Stack stores indices of items waiting for a discount
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Apply discount to previous items that are >= current item
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int index = stack.pop();
                result[index] -= prices[i];
            }
            stack.push(i);
        }

        return result;
    }
}