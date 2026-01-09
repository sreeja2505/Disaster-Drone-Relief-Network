# Longest Proper Prefix-Suffix Solution

## Problem Statement

Given a string `S` consisting of N characters, return the length of the longest string that is both a proper prefix of S and a proper suffix of S.

**Definitions:**
- A **proper prefix** is a prefix that is not equal to the string itself
- A **proper suffix** is a suffix that is not equal to the string itself

## Example

For `S = "abbabba"`:
- Proper prefixes: `""`, `"a"`, `"ab"`, `"abb"`, `"abba"`, `"abbab"`, `"abbabb"`
- Proper suffixes: `""`, `"a"`, `"ba"`, `"bba"`, `"abba"`, `"babba"`, `"bbabba"`
- Longest match: `"abba"` with length **4**

## Solution

The solution is implemented in `src/main/java/Solution.java` using the **KMP (Knuth-Morris-Pratt)** algorithm's failure function concept.

### Algorithm Approach

The algorithm builds an LPS (Longest Proper Prefix which is also Suffix) array:
1. Initialize an array `lps[]` of size N
2. For each position i, `lps[i]` represents the length of the longest proper prefix of substring `S[0...i]` which is also a suffix
3. The last value `lps[N-1]` gives us the answer for the entire string

### Complexity

- **Time Complexity**: O(N) - Single pass through the string
- **Space Complexity**: O(N) - For the LPS array

### Key Features

- Efficient O(N) time complexity (handles strings up to 1,000,000 characters)
- Handles edge cases (empty strings, null, single character)
- Uses only lowercase letters (a-z) as per requirements

## Running the Code

### Compile the Solution

```bash
javac -d build/classes src/main/java/Solution.java
```

### Run Tests

```bash
javac -d build/classes src/main/java/Solution.java src/test/java/TestRunner.java
java -cp build/classes TestRunner
```

### Run JUnit Tests (if JUnit is available)

```bash
./gradlew test -b build-solution.gradle
```

## Test Cases

The implementation includes comprehensive test coverage:
- Example case from problem statement
- Edge cases (empty, null, single character)
- No matching prefix-suffix
- Repeating patterns
- Palindromes
- All same characters
- Performance test with 200,000 character string (completes in ~7ms)

## File Structure

```
src/
├── main/
│   └── java/
│       └── Solution.java          # Main solution implementation
└── test/
    └── java/
        ├── TestRunner.java        # Standalone test runner
        ├── SolutionTest.java      # JUnit tests
        └── DebugHelper.java       # Debug utility for analyzing strings
```

## Usage Example

```java
Solution solution = new Solution();
int result = solution.solution("abbabba");
System.out.println(result); // Output: 4
```
