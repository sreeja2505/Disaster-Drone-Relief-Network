/**
 * Debug helper to understand the LPS array for a given string
 */
public class DebugHelper {
    
    public static void main(String[] args) {
        String test = "aabaabaab";
        System.out.println("Analyzing string: " + test);
        System.out.println("Length: " + test.length());
        
        System.out.println("\nProper prefixes (excluding the string itself):");
        for (int i = 0; i < test.length(); i++) {
            System.out.println("  \"" + test.substring(0, i) + "\"");
        }
        
        System.out.println("\nProper suffixes (excluding the string itself):");
        for (int i = 1; i <= test.length(); i++) {
            System.out.println("  \"" + test.substring(i) + "\"");
        }
        
        System.out.println("\nMatching proper prefix-suffixes:");
        int maxLen = 0;
        String maxMatch = "";
        for (int i = 0; i < test.length(); i++) {
            String prefix = test.substring(0, i);
            for (int j = 1; j <= test.length(); j++) {
                String suffix = test.substring(j);
                if (prefix.equals(suffix) && prefix.length() > maxLen) {
                    maxLen = prefix.length();
                    maxMatch = prefix;
                }
            }
        }
        System.out.println("  Longest: \"" + maxMatch + "\" with length " + maxLen);
        
        // Run the solution
        Solution solution = new Solution();
        int result = solution.solution(test);
        System.out.println("\nSolution result: " + result);
        
        // Build LPS array step by step
        System.out.println("\nLPS array construction:");
        int n = test.length();
        int[] lps = new int[n];
        lps[0] = 0;
        int len = 0;
        int i = 1;
        
        while (i < n) {
            System.out.println("  i=" + i + ", len=" + len + ", char[i]='" + test.charAt(i) + "', char[len]='" + test.charAt(len) + "'");
            if (test.charAt(i) == test.charAt(len)) {
                len++;
                lps[i] = len;
                System.out.println("    Match! lps[" + i + "] = " + len);
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                    System.out.println("    No match, backtrack: len = lps[" + (len + 1) + "] = " + len);
                } else {
                    lps[i] = 0;
                    System.out.println("    No match, len=0: lps[" + i + "] = 0");
                    i++;
                }
            }
        }
        
        System.out.println("\nFinal LPS array:");
        for (int k = 0; k < n; k++) {
            System.out.println("  lps[" + k + "] = " + lps[k] + " (char: '" + test.charAt(k) + "')");
        }
    }
}
