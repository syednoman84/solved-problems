#!/bin/bash

# Script to run DynamicProgrammingI unit tests

echo "Running DynamicProgrammingI Unit Tests..."
echo "========================================="

cd "$(dirname "$0")"

# Run tests using Maven
mvn test -Dtest="problems.DynamicProgrammingI.*Test"

echo ""
echo "Test execution completed!"