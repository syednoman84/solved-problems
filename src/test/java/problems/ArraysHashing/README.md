# ArraysHashing Unit Tests

This directory contains comprehensive unit tests for all problems in the ArraysHashing package.

## Test Coverage

The following problems have unit tests:

1. **ContainsDuplicate** - Tests for duplicate detection in arrays
2. **ValidAnagram** - Tests for anagram validation
3. **TwoSum** - Tests for finding two numbers that sum to target
4. **GroupAnagrams** - Tests for grouping anagrams together
5. **TopKElements** - Tests for finding k most frequent elements
6. **ProductOfArrayExceptSelf** - Tests for product calculation excluding self
7. **ValidSodoku** - Tests for Sudoku board validation
8. **EncodeAndDecodeStrings** - Tests for string encoding/decoding
9. **LongestConsecutiveSequence** - Tests for finding longest consecutive sequence

## Running Tests

### Using Maven
```bash
# Run all ArraysHashing tests
mvn test -Dtest="problems.ArraysHashing.*Test"

# Run a specific test class
mvn test -Dtest="problems.ArraysHashing.TwoSumTest"
```

### Using the provided script
```bash
# Make script executable (if not already)
chmod +x run-arrays-hashing-tests.sh

# Run all tests
./run-arrays-hashing-tests.sh
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

## Dependencies

The tests use JUnit 5 (Jupiter) which is included in the project's `pom.xml`:
- `junit-jupiter` for test framework
- `maven-surefire-plugin` for running tests with Maven