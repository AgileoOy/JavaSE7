#!/bin/bash

echo "***This Script is cleaning files compiled with maven***"
for f in advanced  basics  collections  objects ;
  do 
     [ -d $f ] && cd "$f" && echo entering $f ... 
     mvn clean
     cd ..
  done
