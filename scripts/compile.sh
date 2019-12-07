#!/bin/bash

mkdir -p ../bin/
rm -rf ../bin/*

cd ../app/democlub
./mvnw clean package -DskipTests -Dmaven.javadoc.skip=true -B -V

cp target/*.jar ../bin/
