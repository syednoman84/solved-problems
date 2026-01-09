# AdvancedGraphs Unit Tests

This directory contains comprehensive unit tests for all problems in the AdvancedGraphs package.

## Test Coverage

The following problems have unit tests:

1. **MinCostToConnectAllPoints** - Tests for minimum spanning tree using Prim's algorithm
2. **NetworkDelayTime** - Tests for shortest path using modified Dijkstra's algorithm  
3. **CheapestFlightsWithinKStops** - Tests for shortest path with constraints using Bellman-Ford

## Running Tests

### Using Maven
```bash
# Run all AdvancedGraphs tests
mvn test -Dtest="problems.AdvancedGraphs.*Test"

# Run a specific test class
mvn test -Dtest="problems.AdvancedGraphs.MinCostToConnectAllPointsTest"
```

### Using the provided script
```bash
# Make script executable (if not already)
chmod +x run-advanced-graphs-tests.sh

# Run all tests
./run-advanced-graphs-tests.sh
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

## Test Cases

### MinCostToConnectAllPointsTest
- Basic MST calculation with multiple points
- Three points forming a triangle
- Single point (cost = 0)
- Two points (Manhattan distance)
- Square formation (optimal MST)

### NetworkDelayTimeTest
- Basic network delay calculation
- Simple two-node network
- Unreachable destination
- Empty network
- Linear chain network

### CheapestFlightsWithinKStopsTest
- Basic flight routing with stops constraint
- Multiple path options
- Direct flight vs multi-stop
- No valid route
- Direct flight only

## Dependencies

The tests use JUnit 5 (Jupiter) which is included in the project's `pom.xml`:
- `junit-jupiter` for test framework
- `maven-surefire-plugin` for running tests with Maven