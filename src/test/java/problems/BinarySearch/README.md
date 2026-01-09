# BinarySearch Unit Tests

This directory contains comprehensive unit tests for problems in the BinarySearch package.

## Test Coverage

The following problems have unit tests:

1. **BinarySearch** - Tests for classic binary search in sorted arrays
2. **SearchIn2DMatrix** - Tests for searching in 2D sorted matrices
3. **KokoEatingBananas** - Tests for binary search on answer space

## Running Tests

### Using Maven
```bash
# Run all BinarySearch tests
mvn test -Dtest="problems.BinarySearch.*Test"

# Run a specific test class
mvn test -Dtest="problems.BinarySearch.BinarySearchTest"
```

### Using the provided script
```bash
# Make script executable (if not already)
chmod +x run-binary-search-tests.sh

# Run all tests
./run-binary-search-tests.sh
```

## Test Structure

Each test class follows the naming convention `[ClassName]Test.java` and includes:
- Multiple test cases covering edge cases
- Assertions for expected vs actual results
- Clear test method names describing what is being tested

## Binary Search Algorithm Patterns Tested

### 1. Classic Binary Search (BinarySearch)
- Standard binary search in sorted array
- Target found and not found cases
- Single element arrays

### 2. 2D Matrix Search (SearchIn2DMatrix)
- Search in row-wise and column-wise sorted matrix
- Start from top-right corner approach
- Matrix boundary handling

### 3. Binary Search on Answer (KokoEatingBananas)
- Binary search on possible answer range
- Feasibility function validation
- Optimization problems using binary search

## Dependencies

The tests use JUnit 5 (Jupiter) which is included in the project's `pom.xml`.