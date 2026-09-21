import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        // Map to store character and its last seen index
        HashMap<Character, Integer> charMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If character is already in window, shrink window from left
            if (charMap.containsKey(currentChar) && charMap.get(currentChar) >= left) {
                left = charMap.get(currentChar) + 1;
            }

            // Update/insert character index
            charMap.put(currentChar, right);

            // Calculate current window size
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}