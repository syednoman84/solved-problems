#!/bin/bash

# Script to run AdvancedGraphs unit tests

echo "Running AdvancedGraphs Unit Tests..."
echo "==================================="

cd "$(dirname "$0")"

# Run tests using Maven
mvn test -Dtest="problems.AdvancedGraphs.*Test"

echo ""
echo "Test execution completed!"