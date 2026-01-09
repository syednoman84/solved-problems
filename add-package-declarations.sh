#!/bin/bash

# Script to add package declarations to all Java files

echo "Adding package declarations to all Java files..."

# Function to add package declaration
add_package_declaration() {
    local file="$1"
    local package_name="$2"
    
    # Check if file already has package declaration
    if grep -q "^package " "$file"; then
        echo "Skipping $file (already has package declaration)"
        return
    fi
    
    # Get the first line to determine what to replace
    first_line=$(head -n 1 "$file")
    
    if [[ "$first_line" == "public class"* ]] || [[ "$first_line" == "class"* ]]; then
        # Replace class declaration
        sed -i '' "1s/^/package $package_name;\n\n/" "$file"
    elif [[ "$first_line" == "import"* ]]; then
        # Replace import statement
        sed -i '' "1s/^/package $package_name;\n\n/" "$file"
    elif [[ "$first_line" == "/**"* ]] || [[ "$first_line" == "/*"* ]]; then
        # Replace comment
        sed -i '' "1s/^/package $package_name;\n\n/" "$file"
    else
        # Just add at the beginning
        sed -i '' "1s/^/package $package_name;\n\n/" "$file"
    fi
    
    echo "Added package declaration to $file"
}

# Process all directories
for dir in src/main/java/problems/*/; do
    if [ -d "$dir" ]; then
        package_name="problems.$(basename "$dir")"
        echo "Processing package: $package_name"
        
        for file in "$dir"*.java; do
            if [ -f "$file" ]; then
                add_package_declaration "$file" "$package_name"
            fi
        done
    fi
done

echo "Package declaration addition completed!"