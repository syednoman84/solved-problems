#!/bin/bash

# Script to run BitManipulation unit tests

echo "Running BitManipulation Unit Tests..."
echo "===================================="

cd "$(dirname "$0")/.."

# Run tests using Maven
mvn test -Dtest="problems.BitManipulation.*Test"

echo ""
echo "Test execution completed!"