import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        int n = words.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Check if words[i] is a substring of words[j] (and not the same index)
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break; // Move to the next word once a match is found
                }
            }
        }

        return result;
    }
}