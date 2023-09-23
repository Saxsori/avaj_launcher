#!/bin/bash

SOURCE_DIR="src"

BUILD_DIR="build"

JAR_FILE="simulator:1.0.jar"

mkdir -p "$BUILD_DIR"

find ./src -name '*.java' > sources.txt

javac -d $BUILD_DIR @sources.txt

if [ $? -eq 0 ]; then
    echo "Compilation successful."
    
	echo -n "Main-Class: ae.fortytwo.App" > manifest.txt

	jar cf "$JAR_FILE" manifest.txt -C "$BUILD_DIR" .
    
	if [ $? -eq 0 ]; then
    
	    echo "JAR file '$JAR_FILE' created successfully."
    
	    java -jar "$JAR_FILE"
	else
        echo "Failed to create JAR file."
    fi
else
    echo "Compilation failed."
fi
