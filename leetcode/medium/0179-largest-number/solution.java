import java.util.Arrays;

public class Solution {
    public String largestNumber(int[] nums) {
        // 1. Convert integers to string representations
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // 2. Custom sort based on concatenation comparison
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

        // 3. Edge case: if highest value is "0", result is "0"
        if (strs[0].equals("0")) {
            return "0";
        }

        // 4. Combine sorted strings
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }

        return sb.toString();
    }
}