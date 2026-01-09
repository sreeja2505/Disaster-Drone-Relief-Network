/**
 * Simple test runner to manually verify the Solution class without JUnit
 */
public class TestRunner {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test counter
        int passed = 0;
        int failed = 0;
        
        // Test 1: Example from problem statement
        System.out.println("Test 1: Example case 'abbabba'");
        int result1 = solution.solution("abbabba");
        if (result1 == 4) {
            System.out.println("✓ PASSED: Expected 4, got " + result1);
            passed++;
        } else {
            System.out.println("✗ FAILED: Expected 4, got " + result1);
            failed++;
        }
        
        // Test 2: Single character
        System.out.println("\nTest 2: Single character 'a'");
        int result2 = solution.solution("a");
        if (result2 == 0) {
            System.out.println("✓ PASSED: Expected 0, got " + result2);
            passed++;
        } else {
            System.out.println("✗ FAILED: Expected 0, got " + result2);
            failed++;
        }
        
        // Test 3: No match
        System.out.println("\nTest 3: No match 'abcdef'");
        int result3 = solution.solution("abcdef");
        if (result3 == 0) {
            System.out.println("✓ PASSED: Expected 0, got " + result3);
            passed++;
        } else {
            System.out.println("✗ FAILED: Expected 0, got " + result3);
            failed++;
        }
        
        // Test 4: Repeating pattern
        System.out.println("\nTest 4: Repeating pattern 'abab'");
        int result4 = solution.solution("abab");
        if (result4 == 2) {
            System.out.println("✓ PASSED: Expected 2, got " + result4);
            passed++;
        } else {
            System.out.println("✗ FAILED: Expected 2, got " + result4);
            failed++;
        }
        
        // Test 5: All same characters
        System.out.println("\nTest 5: All same characters 'aaaaa'");
        int result5 = solution.solution("aaaaa");
        if (result5 == 4) {
            System.out.println("✓ PASSED: Expected 4, got " + result5);
            passed++;
        } else {
            System.out.println("✗ FAILED: Expected 4, got " + result5);
            failed++;
        }
        
        // Test 6: Empty string
        System.out.println("\nTest 6: Empty string ''");
        int result6 = solution.solution("");
        if (result6 == 0) {
            System.out.println("✓ PASSED: Expected 0, got " + result6);
            passed++;
        } else {
            System.out.println("✗ FAILED: Expected 0, got " + result6);
            failed++;
        }
        
        // Test 7: Null string
        System.out.println("\nTest 7: Null string");
        int result7 = solution.solution(null);
        if (result7 == 0) {
            System.out.println("✓ PASSED: Expected 0, got " + result7);
            passed++;
        } else {
            System.out.println("✗ FAILED: Expected 0, got " + result7);
            failed++;
        }
        
        // Test 8: Longer pattern
        System.out.println("\nTest 8: Longer pattern 'abcabc'");
        int result8 = solution.solution("abcabc");
        if (result8 == 3) {
            System.out.println("✓ PASSED: Expected 3, got " + result8);
            passed++;
        } else {
            System.out.println("✗ FAILED: Expected 3, got " + result8);
            failed++;
        }
        
        // Test 9: Two characters same
        System.out.println("\nTest 9: Two same characters 'aa'");
        int result9 = solution.solution("aa");
        if (result9 == 1) {
            System.out.println("✓ PASSED: Expected 1, got " + result9);
            passed++;
        } else {
            System.out.println("✗ FAILED: Expected 1, got " + result9);
            failed++;
        }
        
        // Test 10: Palindrome
        System.out.println("\nTest 10: Palindrome 'abba'");
        int result10 = solution.solution("abba");
        if (result10 == 1) {
            System.out.println("✓ PASSED: Expected 1, got " + result10);
            passed++;
        } else {
            System.out.println("✗ FAILED: Expected 1, got " + result10);
            failed++;
        }
        
        // Test 11: Complex pattern
        System.out.println("\nTest 11: Complex pattern 'aabaabaab'");
        int result11 = solution.solution("aabaabaab");
        if (result11 == 6) {
            System.out.println("✓ PASSED: Expected 6, got " + result11);
            passed++;
        } else {
            System.out.println("✗ FAILED: Expected 6, got " + result11);
            failed++;
        }
        
        // Test 12: Performance test with large string
        System.out.println("\nTest 12: Performance test with large string (200,000 chars)");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append("ab");
        }
        long startTime = System.currentTimeMillis();
        int result12 = solution.solution(sb.toString());
        long endTime = System.currentTimeMillis();
        if (result12 == 199998) {
            System.out.println("✓ PASSED: Expected 199998, got " + result12);
            System.out.println("  Execution time: " + (endTime - startTime) + "ms");
            passed++;
        } else {
            System.out.println("✗ FAILED: Expected 199998, got " + result12);
            failed++;
        }
        
        // Summary
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Test Results Summary:");
        System.out.println("  Passed: " + passed);
        System.out.println("  Failed: " + failed);
        System.out.println("  Total:  " + (passed + failed));
        System.out.println("=".repeat(50));
        
        if (failed == 0) {
            System.out.println("\n✓ All tests passed!");
        } else {
            System.out.println("\n✗ Some tests failed!");
            System.exit(1);
        }
    }
}
