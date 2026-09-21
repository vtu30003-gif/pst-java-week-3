import java.util.*;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }
        
        return result;
    }
    
    private boolean matches(String word, String pattern) {
        int[] pToW = new int[26];
        int[] wToP = new int[26];
        
        for (int i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            char w = word.charAt(i);
            
            // Map 1-indexed to distinguish unmapped (0) from mapped positions
            if (pToW[p - 'a'] == 0 && wToP[w - 'a'] == 0) {
                pToW[p - 'a'] = w - 'a' + 1;
                wToP[w - 'a'] = p - 'a' + 1;
            } else if (pToW[p - 'a'] != w - 'a' + 1 || wToP[w - 'a'] != p - 'a' + 1) {
                return false;
            }
        }
        
        return true;
    }
}