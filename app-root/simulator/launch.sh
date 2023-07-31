#!/bin/bash
mvn clean install
mvn clean package
java -jar /home/T0290314/MyProjects/avaj/simulator/target/simulator-1.0-SNAPSHOT.jar "src/main/resources/scenario.txt"