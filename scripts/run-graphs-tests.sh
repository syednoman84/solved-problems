#!/bin/bash

# Graphs Package Test Runner
# This script runs all unit tests for the Graphs package

echo "=========================================="
echo "       Graphs Package Test Runner"
echo "=========================================="

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Function to print colored output
print_status() {
    if [ $1 -eq 0 ]; then
        echo -e "${GREEN}✓ $2${NC}"
    else
        echo -e "${RED}✗ $2${NC}"
    fi
}

# Change to project root directory
cd "$(dirname "$0")/.."

echo -e "${BLUE}Running Graphs package tests...${NC}"
echo ""

# Check if Maven is available
if ! command -v mvn &> /dev/null; then
    echo -e "${RED}Maven is not installed or not in PATH${NC}"
    exit 1
fi

# Run tests based on argument
case "${1:-all}" in
    "all")
        echo -e "${YELLOW}Running all Graphs tests...${NC}"
        mvn test -Dtest="problems.Graphs.*Test" -q
        print_status $? "All Graphs tests completed"
        ;;
    "suite")
        echo -e "${YELLOW}Running Graphs test suite...${NC}"
        mvn test -Dtest="problems.Graphs.GraphsTestSuite" -q
        print_status $? "Graphs test suite completed"
        ;;
    "islands")
        echo -e "${YELLOW}Running island-related tests...${NC}"
        mvn test -Dtest="problems.Graphs.NumberOfIslandsTest,problems.Graphs.MaxAreaOfIslandTest" -q
        print_status $? "Island tests completed"
        ;;
    "course")
        echo -e "${YELLOW}Running course schedule tests...${NC}"
        mvn test -Dtest="problems.Graphs.CourseScheduleTest,problems.Graphs.CourseScheduleIITest" -q
        print_status $? "Course schedule tests completed"
        ;;
    "bfs")
        echo -e "${YELLOW}Running BFS-related tests...${NC}"
        mvn test -Dtest="problems.Graphs.RottenOrangesTest,problems.Graphs.WallsAndGatesTest,problems.Graphs.WordLadderTest" -q
        print_status $? "BFS tests completed"
        ;;
    "dfs")
        echo -e "${YELLOW}Running DFS-related tests...${NC}"
        mvn test -Dtest="problems.Graphs.NumberOfIslandsTest,problems.Graphs.MaxAreaOfIslandTest,problems.Graphs.PacificAtlanticWaterFlowTest,problems.Graphs.SurroundedRegionsTest" -q
        print_status $? "DFS tests completed"
        ;;
    "union-find")
        echo -e "${YELLOW}Running Union-Find tests...${NC}"
        mvn test -Dtest="problems.Graphs.RedundantConnectionTest,problems.Graphs.NumberOfConnectedComponentsInAnUndirectedGraphTest,problems.Graphs.GraphValidTreeTest" -q
        print_status $? "Union-Find tests completed"
        ;;
    "verbose")
        echo -e "${YELLOW}Running all tests with verbose output...${NC}"
        mvn test -Dtest="problems.Graphs.*Test"
        print_status $? "Verbose test run completed"
        ;;
    *)
        echo -e "${YELLOW}Running specific test: $1${NC}"
        mvn test -Dtest="problems.Graphs.$1" -q
        print_status $? "Test $1 completed"
        ;;
esac

echo ""
echo -e "${BLUE}Test execution finished.${NC}"
echo ""
echo "Usage: $0 [option]"
echo "Options:"
echo "  all        - Run all Graphs tests (default)"
echo "  suite      - Run the complete test suite"
echo "  islands    - Run island-related tests"
echo "  course     - Run course schedule tests"
echo "  bfs        - Run BFS algorithm tests"
echo "  dfs        - Run DFS algorithm tests"
echo "  union-find - Run Union-Find data structure tests"
echo "  verbose    - Run all tests with detailed output"
echo "  [TestName] - Run specific test class"
echo ""
echo "Examples:"
echo "  $0 all"
echo "  $0 islands"
echo "  $0 NumberOfIslandsTest"
echo "  $0 verbose"