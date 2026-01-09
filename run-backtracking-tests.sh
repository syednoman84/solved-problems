#!/bin/bash

# Script to run Backtracking unit tests

echo "Running Backtracking Unit Tests..."
echo "=================================="

cd "$(dirname "$0")"

# Run tests using Maven
mvn test -Dtest="problems.Backtracking.*Test"

echo ""
echo "Test execution completed!"