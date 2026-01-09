# DynamicProgrammingII Unit Tests

This directory contains comprehensive unit tests for 2D Dynamic Programming problems.

## Test Coverage

The following problems have unit tests:

1. **UniquePaths** - Tests for 2D grid path counting
2. **LongestCommonSubsequence** - Tests for classic LCS problem
3. **EditDistance** - Tests for string transformation operations

## Running Tests

### Using Maven
```bash
# Run all DynamicProgrammingII tests
mvn test -Dtest="problems.DynamicProgrammingII.*Test"

# Run a specific test class
mvn test -Dtest="problems.DynamicProgrammingII.UniquePathsTest"
```

### Using the provided script
```bash
# Make script executable (if not already)
chmod +x run-dynamic-programming-ii-tests.sh

# Run all tests
./run-dynamic-programming-ii-tests.sh
```

## Test Structure

Each test class follows the naming convention `[ClassName]Test.java` and includes:
- Multiple test cases covering edge cases
- Assertions for expected vs actual results
- Clear test method names describing what is being tested

## 2D Dynamic Programming Patterns Tested

### 1. Grid DP (UniquePaths)
- 2D grid traversal counting
- Bottom-up DP approach
- Boundary conditions (single row/column)

### 2. String DP (LongestCommonSubsequence)
- Classic LCS with 2D table
- Character matching logic
- Subsequence vs substring distinction

### 3. String Transformation (EditDistance)
- Minimum edit operations (insert, delete, replace)
- 2D DP table for string alignment
- Optimal substructure in string problems

## Dependencies

The tests use JUnit 5 (Jupiter) which is included in the project's `pom.xml`.