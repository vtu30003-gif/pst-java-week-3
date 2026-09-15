import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Map<Integer, String> map = new HashMap<>();

        // Map each height to the person's name
        for (int i = 0; i < n; i++) {
            map.put(heights[i], names[i]);
        }

        // Sort heights in ascending order
        Arrays.sort(heights);

        // Populate result array in descending order of height
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = map.get(heights[n - 1 - i]);
        }

        return result;
    }
}