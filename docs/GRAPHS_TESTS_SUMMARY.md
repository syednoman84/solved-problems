# Graphs Unit Tests Summary

## Overview
Created comprehensive unit tests for all 13 problems in the Graphs package using JUnit 5, covering fundamental graph algorithms including DFS, BFS, topological sorting, and Union-Find data structures.

## Test Files Created

### 1. NumberOfIslandsTest.java
- Tests DFS-based island counting algorithm
- Test cases: multiple islands, single island, no islands, edge cases
- Validates connected component identification in 2D grids
- **Algorithm**: DFS with visited marking

### 2. CloneGraphTest.java
- Tests deep graph cloning with BFS traversal
- Test cases: null graph, single node, connected graphs, complex cycles
- Validates proper node cloning and neighbor relationships
- **Algorithm**: BFS with HashMap for node mapping

### 3. MaxAreaOfIslandTest.java
- Tests DFS-based area calculation for largest island
- Test cases: different island sizes, no islands, complex shapes
- Validates maximum area computation across all islands
- **Algorithm**: DFS with area accumulation

### 4. CourseScheduleTest.java
- Tests topological sorting for cycle detection
- Test cases: valid schedules, cycles, no prerequisites, complex dependencies
- Validates course completion feasibility
- **Algorithm**: Kahn's topological sort with in-degree tracking

### 5. CourseScheduleIITest.java
- Tests topological ordering generation
- Test cases: valid ordering, cycles, multiple valid orders
- Validates correct prerequisite ordering
- **Algorithm**: Topological sort with result array generation

### 6. PacificAtlanticWaterFlowTest.java
- Tests multi-source DFS for water flow simulation
- Test cases: different height matrices, boundary conditions
- Validates cells reachable by both oceans
- **Algorithm**: DFS from boundaries with height constraints

### 7. SurroundedRegionsTest.java
- Tests boundary-connected region identification
- Test cases: surrounded regions, boundary connections, edge cases
- Validates region capture logic
- **Algorithm**: DFS from boundaries to mark safe regions

### 8. RottenOrangesTest.java
- Tests multi-source BFS for time-based propagation
- Test cases: standard propagation, impossible scenarios, edge cases
- Validates minimum time calculation for complete rot
- **Algorithm**: BFS with level-order processing

### 9. WallsAndGatesTest.java
- Tests multi-source BFS for shortest distance calculation
- Test cases: multiple gates, walls, unreachable rooms
- Validates distance computation to nearest gate
- **Algorithm**: BFS from all gates simultaneously

### 10. RedundantConnectionTest.java
- Tests Union-Find for cycle detection in tree construction
- Test cases: different cycle patterns, redundant edge identification
- Validates last edge that creates a cycle
- **Algorithm**: Union-Find with path compression

### 11. NumberOfConnectedComponentsInAnUndirectedGraphTest.java
- Tests DFS-based connected component counting
- Test cases: multiple components, single component, isolated nodes
- Validates component identification in undirected graphs
- **Algorithm**: DFS with visited tracking

### 12. GraphValidTreeTest.java
- Tests tree validation using DFS and edge counting
- Test cases: valid trees, cycles, disconnected components
- Validates n-1 edges and connectivity requirements
- **Algorithm**: DFS connectivity check + edge count validation

### 13. WordLadderTest.java
- Tests BFS for shortest transformation path
- Test cases: valid transformations, impossible paths, edge cases
- Validates minimum steps for word transformation
- **Algorithm**: BFS with graph construction for word differences

## Graph Algorithm Categories Covered

### 1. Depth-First Search (DFS)
```java
// Standard DFS pattern for grid problems
private void dfs(int[][] grid, int i, int j, boolean[][] visited) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || 
        visited[i][j] || grid[i][j] == 0) return;
    
    visited[i][j] = true;
    dfs(grid, i+1, j, visited);  // Down
    dfs(grid, i-1, j, visited);  // Up
    dfs(grid, i, j+1, visited); // Right
    dfs(grid, i, j-1, visited); // Left
}
```

### 2. Breadth-First Search (BFS)
```java
// Multi-source BFS pattern
Queue<int[]> queue = new LinkedList<>();
// Add all sources to queue
while (!queue.isEmpty()) {
    int size = queue.size();
    for (int i = 0; i < size; i++) {
        int[] current = queue.poll();
        // Process neighbors
        for (int[] dir : directions) {
            int newX = current[0] + dir[0];
            int newY = current[1] + dir[1];
            if (isValid(newX, newY)) {
                queue.offer(new int[]{newX, newY});
            }
        }
    }
    level++; // Track BFS levels
}
```

### 3. Topological Sort
```java
// Kahn's algorithm for topological sorting
Map<Integer, List<Integer>> graph = new HashMap<>();
Map<Integer, Integer> inDegree = new HashMap<>();

// Build graph and calculate in-degrees
Queue<Integer> sources = new LinkedList<>();
for (int node : nodes) {
    if (inDegree.get(node) == 0) {
        sources.offer(node);
    }
}

while (!sources.isEmpty()) {
    int current = sources.poll();
    result.add(current);
    for (int neighbor : graph.get(current)) {
        inDegree.put(neighbor, inDegree.get(neighbor) - 1);
        if (inDegree.get(neighbor) == 0) {
            sources.offer(neighbor);
        }
    }
}
```

### 4. Union-Find (Disjoint Set)
```java
// Union-Find with path compression and union by rank
class UnionFind {
    int[] parent, rank;
    
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }
    
    public boolean union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY) return false; // Already connected
        
        // Union by rank
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return true;
    }
}
```

## Project Organization

### Directory Structure
```
├── src/test/java/problems/Graphs/
│   ├── NumberOfIslandsTest.java
│   ├── CloneGraphTest.java
│   ├── MaxAreaOfIslandTest.java
│   ├── CourseScheduleTest.java
│   ├── CourseScheduleIITest.java
│   ├── PacificAtlanticWaterFlowTest.java
│   ├── SurroundedRegionsTest.java
│   ├── RottenOrangesTest.java
│   ├── WallsAndGatesTest.java
│   ├── RedundantConnectionTest.java
│   ├── NumberOfConnectedComponentsInAnUndirectedGraphTest.java
│   ├── GraphValidTreeTest.java
│   ├── WordLadderTest.java
│   └── GraphsTestSuite.java
├── scripts/
│   └── run-graphs-tests.sh
└── docs/
    └── GRAPHS_TESTS_SUMMARY.md
```

### Test Infrastructure
- **Test Suite Runner**: `GraphsTestSuite.java` for running all tests
- **Shell Script**: `scripts/run-graphs-tests.sh` with multiple execution options
- **Documentation**: Comprehensive guides and algorithm explanations

## Running Tests

### Command Line Options
```bash
# Run all Graphs tests
mvn test -Dtest="problems.Graphs.*Test"

# Run specific algorithm category
./scripts/run-graphs-tests.sh dfs      # DFS tests
./scripts/run-graphs-tests.sh bfs      # BFS tests
./scripts/run-graphs-tests.sh union-find  # Union-Find tests

# Run specific test
mvn test -Dtest="problems.Graphs.NumberOfIslandsTest"

# Use provided script with options
./scripts/run-graphs-tests.sh all     # All tests
./scripts/run-graphs-tests.sh islands # Island problems
./scripts/run-graphs-tests.sh course  # Course scheduling
./scripts/run-graphs-tests.sh verbose # Detailed output
```

### IDE Integration
- All major IDEs support JUnit 5 test execution
- Right-click on package/class to run tests
- Integrated test results and debugging

## Test Coverage Analysis

### Algorithm Categories
1. **Grid-based DFS** - Island problems, region identification
2. **Multi-source BFS** - Time-based propagation, shortest distances
3. **Topological Sorting** - Dependency resolution, cycle detection
4. **Union-Find** - Connectivity, cycle detection in tree construction
5. **Graph Traversal** - Cloning, connectivity analysis
6. **Shortest Path** - Word transformation, minimum steps

### Problem Types Covered
- **2D Grid Problems**: Islands, regions, water flow
- **Course Scheduling**: Topological ordering, cycle detection
- **Tree Validation**: Connectivity and structural validation
- **Graph Connectivity**: Component counting, reachability
- **Shortest Path**: Transformation sequences, minimum distances

### Edge Cases Covered
- **Empty Inputs**: Null graphs, empty grids
- **Single Elements**: Single nodes, single cells
- **Boundary Conditions**: Grid edges, isolated components
- **Cycles**: Detection and handling in various contexts
- **Impossible Scenarios**: Unreachable states, invalid configurations

## Complexity Analysis

### Time Complexity
- **DFS/BFS on Grids**: O(m×n) where m,n are grid dimensions
- **Graph DFS/BFS**: O(V+E) where V=vertices, E=edges
- **Topological Sort**: O(V+E) for graph construction and processing
- **Union-Find**: O(α(n)) amortized per operation with path compression

### Space Complexity
- **Grid Problems**: O(m×n) for visited arrays and recursion stack
- **Graph Problems**: O(V+E) for adjacency lists and visited sets
- **BFS**: O(V) for queue storage
- **Union-Find**: O(V) for parent and rank arrays

### Algorithm Efficiency
- Optimal time complexity for all implemented algorithms
- Efficient space usage with appropriate data structures
- Path compression and union by rank for Union-Find optimization

## Key Learning Outcomes

### Graph Traversal Techniques
1. **DFS Applications**: Connected components, path finding, cycle detection
2. **BFS Applications**: Shortest path, level-order processing, multi-source problems
3. **Bidirectional Search**: Optimization for shortest path problems
4. **Graph Construction**: From grids, edge lists, and implicit relationships

### Advanced Graph Algorithms
1. **Topological Sorting**: Dependency resolution, cycle detection
2. **Union-Find**: Efficient connectivity queries, dynamic connectivity
3. **Multi-source BFS**: Simultaneous propagation from multiple sources
4. **Grid Traversal**: 4-directional and 8-directional movement patterns

### Problem-Solving Patterns
1. **Island Problems**: Connected component identification in grids
2. **Scheduling Problems**: Topological ordering with cycle detection
3. **Propagation Problems**: Time-based spreading using BFS
4. **Connectivity Problems**: Component analysis and reachability

## Status Summary
- **Total Test Classes**: 13
- **Total Test Methods**: 78 individual test cases
- **Algorithm Types**: DFS, BFS, Topological Sort, Union-Find
- **Problem Categories**: Grid traversal, graph connectivity, shortest path, cycle detection
- **Status**: ✅ All tests passing
- **Documentation**: Complete with algorithm explanations and complexity analysis
- **Organization**: Proper directory structure with scripts and comprehensive docs