#!/bin/bash

# Script to run BinarySearch unit tests

echo "Running BinarySearch Unit Tests..."
echo "=================================="

cd "$(dirname "$0")"

# Run tests using Maven
mvn test -Dtest="problems.BinarySearch.*Test"

echo ""
echo "Test execution completed!"