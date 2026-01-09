#!/bin/bash

# Script to run DynamicProgrammingII unit tests

echo "Running DynamicProgrammingII Unit Tests..."
echo "=========================================="

cd "$(dirname "$0")"

# Run tests using Maven
mvn test -Dtest="problems.DynamicProgrammingII.*Test"

echo ""
echo "Test execution completed!"