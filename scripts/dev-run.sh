#!/bin/bash

./compile.sh

if [ -f ../bin/*.jar ]; then
    java -jar ../bin/*.jar 
fi

