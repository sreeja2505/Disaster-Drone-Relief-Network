import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the Solution class.
 * Tests various edge cases and scenarios for finding the longest proper prefix-suffix.
 */
public class SolutionTest {
    
    private final Solution solution = new Solution();
    
    /**
     * Test the example case from the problem statement
     */
    @Test
    public void testExampleCase() {
        assertEquals(4, solution.solution("abbabba"));
    }
    
    /**
     * Test a single character string - should return 0
     */
    @Test
    public void testSingleCharacter() {
        assertEquals(0, solution.solution("a"));
    }
    
    /**
     * Test a string with no matching prefix-suffix
     */
    @Test
    public void testNoMatch() {
        assertEquals(0, solution.solution("abcdef"));
    }
    
    /**
     * Test a string where the entire prefix matches suffix (but proper means not the whole string)
     */
    @Test
    public void testRepeatingPattern() {
        assertEquals(2, solution.solution("abab"));
    }
    
    /**
     * Test a palindrome
     */
    @Test
    public void testPalindrome() {
        assertEquals(0, solution.solution("aba"));
        assertEquals(1, solution.solution("abba"));
    }
    
    /**
     * Test all same characters
     */
    @Test
    public void testAllSameCharacters() {
        assertEquals(4, solution.solution("aaaaa"));
        assertEquals(2, solution.solution("aaa"));
    }
    
    /**
     * Test two character strings
     */
    @Test
    public void testTwoCharacters() {
        assertEquals(0, solution.solution("ab"));
        assertEquals(1, solution.solution("aa"));
    }
    
    /**
     * Test empty string
     */
    @Test
    public void testEmptyString() {
        assertEquals(0, solution.solution(""));
    }
    
    /**
     * Test null string
     */
    @Test
    public void testNullString() {
        assertEquals(0, solution.solution(null));
    }
    
    /**
     * Test longer strings with patterns
     */
    @Test
    public void testLongerPatterns() {
        assertEquals(3, solution.solution("abcabc"));
        assertEquals(0, solution.solution("abcdefg"));
        assertEquals(6, solution.solution("abcabcabc"));
    }
    
    /**
     * Test strings with partial matches
     */
    @Test
    public void testPartialMatches() {
        assertEquals(2, solution.solution("abcdab"));
        assertEquals(4, solution.solution("abcdabcd"));
    }
    
    /**
     * Test complex patterns
     */
    @Test
    public void testComplexPatterns() {
        assertEquals(9, solution.solution("ababababaababababa"));
        assertEquals(6, solution.solution("aabaabaab"));
    }
    
    /**
     * Test string with no repeating pattern at boundaries
     */
    @Test
    public void testNoBoundaryMatch() {
        assertEquals(0, solution.solution("abcdefghij"));
    }
    
    /**
     * Test large string performance (should handle efficiently)
     */
    @Test
    public void testLargeString() {
        // Create a string with repeating pattern to test efficiency
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append("ab");
        }
        // For "ab" repeated n times, the answer should be 2*(n-1)
        int result = solution.solution(sb.toString());
        assertEquals(199998, result);
    }
}
