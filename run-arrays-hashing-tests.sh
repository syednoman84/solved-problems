#!/bin/bash

# Script to run ArraysHashing unit tests

echo "Running ArraysHashing Unit Tests..."
echo "=================================="

cd "$(dirname "$0")"

# Run tests using Maven
mvn test -Dtest="problems.ArraysHashing.*Test"

echo ""
echo "Test execution completed!"