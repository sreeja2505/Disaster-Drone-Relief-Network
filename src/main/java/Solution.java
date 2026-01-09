/**
 * Solution class to find the longest string that is both a proper prefix and proper suffix.
 * 
 * This implementation uses the KMP (Knuth-Morris-Pratt) algorithm's failure function concept
 * to efficiently find the longest proper prefix which is also a proper suffix.
 * 
 * Time Complexity: O(N) where N is the length of the string
 * Space Complexity: O(N) for the LPS array
 */
public class Solution {
    
    /**
     * Returns the length of the longest string that is both a proper prefix and proper suffix of S.
     * 
     * A proper prefix is a prefix that is not equal to the string itself.
     * A proper suffix is a suffix that is not equal to the string itself.
     * 
     * @param S the input string consisting of lowercase letters (a-z)
     * @return the length of the longest proper prefix that is also a proper suffix
     * 
     * Example:
     * - Input: "abbabba"
     * - Proper prefixes: "", "a", "ab", "abb", "abba", "abbab", "abbabb"
     * - Proper suffixes: "", "a", "ba", "bba", "abba", "babba", "bbabba"
     * - Longest match: "abba" with length 4
     * - Output: 4
     */
    public int solution(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        
        int n = S.length();
        
        // Handle single character string - no proper prefix or suffix exists
        if (n == 1) {
            return 0;
        }
        
        // Build the LPS (Longest Proper Prefix which is also Suffix) array
        // This is based on KMP algorithm's failure function
        int[] lps = new int[n];
        lps[0] = 0; // Base case: first character has no proper prefix
        
        int len = 0; // length of the previous longest prefix suffix
        int i = 1;
        
        while (i < n) {
            if (S.charAt(i) == S.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    // Try the previous longest prefix suffix
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        // The last value in the LPS array gives us the length of the longest
        // proper prefix which is also a proper suffix of the entire string
        return lps[n - 1];
    }
}
