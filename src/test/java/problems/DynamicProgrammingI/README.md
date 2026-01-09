# DynamicProgrammingI Unit Tests

This directory contains comprehensive unit tests for 1D Dynamic Programming problems.

## Test Coverage

The following problems have unit tests:

1. **ClimbingStairs** - Tests for Fibonacci-like DP pattern
2. **CoinChange** - Tests for minimum coin change problem
3. **HouseRobber** - Tests for optimal selection with constraints

## Running Tests

### Using Maven
```bash
# Run all DynamicProgrammingI tests
mvn test -Dtest="problems.DynamicProgrammingI.*Test"

# Run a specific test class
mvn test -Dtest="problems.DynamicProgrammingI.ClimbingStairsTest"
```

### Using the provided script
```bash
# Make script executable (if not already)
chmod +x run-dynamic-programming-i-tests.sh

# Run all tests
./run-dynamic-programming-i-tests.sh
```

## Test Structure

Each test class follows the naming convention `[ClassName]Test.java` and includes:
- Multiple test cases covering edge cases
- Assertions for expected vs actual results
- Clear test method names describing what is being tested

## Dynamic Programming Patterns Tested

### 1. Fibonacci Pattern (ClimbingStairs)
- Classic DP recurrence: dp[i] = dp[i-1] + dp[i-2]
- Space-optimized O(1) solution
- Base cases handling

### 2. Unbounded Knapsack (CoinChange)
- Minimum coins to make amount
- DP table initialization and filling
- Impossible cases (-1 return)

### 3. Linear DP with Constraints (HouseRobber)
- Adjacent elements cannot be selected
- Optimal substructure: max(prev, curr + prev_prev)
- Space-optimized implementation

## Dependencies

The tests use JUnit 5 (Jupiter) which is included in the project's `pom.xml`.