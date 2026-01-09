/**
 * Demo application to showcase the Solution class
 */
public class Demo {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        System.out.println("=".repeat(60));
        System.out.println("Longest Proper Prefix-Suffix Solution Demo");
        System.out.println("=".repeat(60));
        
        // Example from problem statement
        String example = "abbabba";
        int result = solution.solution(example);
        
        System.out.println("\nExample from problem statement:");
        System.out.println("Input:  \"" + example + "\"");
        System.out.println("Output: " + result);
        
        System.out.println("\nExplanation:");
        System.out.println("  Proper prefixes: \"\", \"a\", \"ab\", \"abb\", \"abba\", \"abbab\", \"abbabb\"");
        System.out.println("  Proper suffixes: \"\", \"a\", \"ba\", \"bba\", \"abba\", \"babba\", \"bbabba\"");
        System.out.println("  Longest match:   \"abba\" with length " + result);
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Additional Examples:");
        System.out.println("=".repeat(60));
        
        String[] testCases = {
            "a",
            "aa", 
            "abab",
            "abcabc",
            "abcdef",
            "aaaaa"
        };
        
        for (String testCase : testCases) {
            int res = solution.solution(testCase);
            System.out.printf("  %-15s -> %d%n", "\"" + testCase + "\"", res);
        }
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Algorithm Complexity:");
        System.out.println("  Time:  O(N) where N is the length of the string");
        System.out.println("  Space: O(N) for the LPS array");
        System.out.println("=".repeat(60));
    }
}
