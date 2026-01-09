# Backtracking Unit Tests Summary

## Overview
Created comprehensive unit tests for all 9 problems in the Backtracking package using JUnit 5.

## Test Files Created

### 1. SubsetsTest.java
- Tests power set generation using binary choice backtracking
- Test cases: 3-element array (8 subsets), single element, two elements, empty array, 4-element array (16 subsets)
- Validates 2^n subset generation pattern

### 2. CombinationSumTest.java
- Tests combination sum with unlimited element reuse
- Test cases: basic target sums, no valid combinations, single element arrays, exact matches
- Validates recursive choice exploration with repetition allowed

### 3. PermutationsTest.java
- Tests permutation generation using choice marking
- Test cases: 3-element array (6 permutations), two elements, single element, 4-element array (24 permutations)
- Validates n! permutation count and arrangement generation

### 4. SubsetsIITest.java
- Tests subset generation with duplicate element handling
- Test cases: arrays with duplicates, single elements, multiple duplicates, empty arrays
- Validates duplicate elimination while maintaining completeness

### 5. CombinationSumIITest.java
- Tests combination sum without element reuse and duplicate handling
- Test cases: complex arrays with duplicates, simple cases, no solutions, exact matches
- Validates unique combinations without repetition

### 6. WordSearchTest.java
- Tests 2D grid word search using path backtracking
- Test cases: valid word paths, invalid searches, single character grids, path conflicts
- Validates grid traversal and path validation

### 7. PalindromePartitioningTest.java
- Tests string partitioning into palindromic substrings
- Test cases: mixed strings, single characters, palindromic strings, non-palindromic strings
- Validates substring generation and palindrome validation

### 8. LetterCombinationsOfAPhoneTest.java
- Tests phone keypad letter combination generation
- Test cases: multi-digit inputs, empty strings, single digits, different key combinations
- Validates mapping-based backtracking

### 9. NQueensTest.java
- Tests N-Queens constraint satisfaction puzzle
- Test cases: 4x4 board (2 solutions), single queen, impossible cases (2x2, 3x3), 5x5 board (10 solutions)
- Validates constraint checking and solution counting

## Backtracking Algorithm Patterns Covered

### 1. Binary Choice Pattern (Subsets, SubsetsII)
```java
// Include current element
tmp.add(nums[index]);
backtrack(nums, index+1, tmp, ans);
tmp.remove(tmp.size()-1);
// Exclude current element  
backtrack(nums, index+1, tmp, ans);
```

### 2. Multiple Choice Pattern (CombinationSum, CombinationSumII)
```java
for(int i = index; i < nums.length; i++) {
    tmp.add(nums[i]);
    backtrack(nums, i, tmp, ans, target - nums[i]);
    tmp.remove(tmp.size()-1);
}
```

### 3. Permutation Pattern (Permutations)
```java
for(int i = 0; i < nums.length; i++) {
    if(mark[i] == false) {
        mark[i] = true;
        tmp.add(nums[i]);
        backtrack(nums, mark, tmp, ans);
        tmp.remove(tmp.size()-1);
        mark[i] = false;
    }
}
```

### 4. Grid Exploration Pattern (WordSearch)
```java
visited[i][j] = true;
// Try all 4 directions
if(search(i+1, j, index+1, word, board) || 
   search(i-1, j, index+1, word, board) ||
   search(i, j+1, index+1, word, board) ||
   search(i, j-1, index+1, word, board)) {
    return true;
}
visited[i][j] = false;
```

### 5. Constraint Satisfaction Pattern (NQueens)
```java
for(int r = 0; r < n; r++) {
    if(!rw[r] && !ld[r - c + n - 1] && !rd[r + c]) {
        // Place queen and mark constraints
        rw[r] = ld[r - c + n - 1] = rd[r + c] = true;
        row[c] = r;
        backtrack(c+1, n, ans);
        // Remove queen and unmark constraints
        rw[r] = ld[r - c + n - 1] = rd[r + c] = false;
    }
}
```

## Project Setup

### Package Declarations Added:
- Added proper package declarations to all Backtracking classes
- Ensured consistent package structure

### Test Infrastructure:
- Created test directory structure: `src/test/java/problems/Backtracking/`
- Created test suite runner: `BacktrackingTestSuite.java`
- Created shell script: `run-backtracking-tests.sh`
- Created comprehensive README with algorithm explanations

## Running Tests

### Command Line Options:
```bash
# Run all Backtracking tests
mvn test -Dtest="problems.Backtracking.*Test"

# Run specific test
mvn test -Dtest="problems.Backtracking.SubsetsTest"

# Use provided script
./run-backtracking-tests.sh
```

### Test Results:
- All 9 test classes created successfully
- All tests compile and run without errors
- Comprehensive coverage of backtracking algorithm patterns
- Tests validate both algorithmic correctness and edge cases

## Test Coverage Summary:
- **Total Test Classes**: 9
- **Total Test Methods**: 9 (one comprehensive test method per class)
- **Test Cases Covered**: 45+ individual test scenarios
- **Algorithm Patterns**: Binary choice, multiple choice, permutation, grid search, constraint satisfaction
- **Edge Cases**: Empty inputs, single elements, duplicates, impossible cases, boundary conditions
- **Status**: ✅ All tests passing

## Key Algorithmic Concepts Tested:
- **Recursive Exploration**: All algorithms use recursive backtracking
- **State Management**: Proper addition/removal of elements from current path
- **Constraint Checking**: Validation of current state before proceeding
- **Duplicate Handling**: Techniques to avoid duplicate solutions
- **Optimization**: Early termination and pruning strategies
- **Space Complexity**: Efficient use of auxiliary data structures