# Backtracking Unit Tests

This directory contains comprehensive unit tests for all problems in the Backtracking package.

## Test Coverage

The following problems have unit tests:

1. **Subsets** - Tests for generating all possible subsets (power set)
2. **CombinationSum** - Tests for finding combinations that sum to target (with repetition)
3. **Permutations** - Tests for generating all permutations of distinct integers
4. **SubsetsII** - Tests for generating subsets with duplicate handling
5. **CombinationSumII** - Tests for finding combinations that sum to target (without repetition)
6. **WordSearch** - Tests for finding words in a 2D character grid
7. **PalindromePartitioning** - Tests for partitioning strings into palindromes
8. **LetterCombinationsOfAPhone** - Tests for phone number letter combinations
9. **NQueens** - Tests for N-Queens puzzle solutions

## Running Tests

### Using Maven
```bash
# Run all Backtracking tests
mvn test -Dtest="problems.Backtracking.*Test"

# Run a specific test class
mvn test -Dtest="problems.Backtracking.SubsetsTest"
```

### Using the provided script
```bash
# Make script executable (if not already)
chmod +x run-backtracking-tests.sh

# Run all tests
./run-backtracking-tests.sh
```

### Using IDE
Most IDEs (IntelliJ IDEA, Eclipse, VS Code) can run JUnit tests directly:
1. Right-click on the test class or package
2. Select "Run Tests" or "Run All Tests"

## Test Structure

Each test class follows the naming convention `[ClassName]Test.java` and includes:
- Multiple test cases covering edge cases
- Assertions for expected vs actual results
- Clear test method names describing what is being tested

## Backtracking Algorithms Tested

### Core Backtracking Patterns:
1. **Binary Choice** (Subsets, SubsetsII) - Include/exclude each element
2. **Multiple Choice** (CombinationSum, CombinationSumII) - Choose from available options
3. **Permutation** (Permutations) - Arrange elements in different orders
4. **Grid Search** (WordSearch) - Explore 2D grid paths
5. **String Partitioning** (PalindromePartitioning) - Split strings into valid parts
6. **Mapping** (LetterCombinationsOfAPhone) - Map digits to character combinations
7. **Constraint Satisfaction** (NQueens) - Place elements with constraints

## Test Cases

### SubsetsTest
- Power set generation for different array sizes
- Empty array handling
- Validates 2^n subset count

### CombinationSumTest
- Target sum with unlimited element reuse
- No valid combinations
- Single element arrays

### PermutationsTest
- All permutations of distinct elements
- Validates n! permutation count
- Single and empty array cases

### SubsetsIITest
- Duplicate element handling
- Ensures no duplicate subsets
- Various duplicate patterns

### CombinationSumIITest
- Target sum without element reuse
- Duplicate candidate handling
- Edge cases with single elements

### WordSearchTest
- Word finding in 2D grids
- Path validation and backtracking
- Invalid word searches

### PalindromePartitioningTest
- String partitioning into palindromes
- Single character and complex strings
- Validates all valid partitions

### LetterCombinationsOfAPhoneTest
- Phone keypad letter combinations
- Empty input handling
- Different digit combinations

### NQueensTest
- N-Queens puzzle solutions
- Various board sizes
- Validates constraint satisfaction

## Dependencies

The tests use JUnit 5 (Jupiter) which is included in the project's `pom.xml`:
- `junit-jupiter` for test framework
- `maven-surefire-plugin` for running tests with Maven