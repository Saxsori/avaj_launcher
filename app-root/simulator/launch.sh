#!/bin/bash
mvn clean install
mvn clean package

java -jar ./target/simulator-1.0-SNAPSHOT.jar "src/main/resources/scenario.txt"