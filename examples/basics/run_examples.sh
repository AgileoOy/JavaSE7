#!/bin/bash
echo "Running Java Basic examples with Maven using Command Line tools"

mvn clean compile 
echo "*****example: *****"
mvn exec:java -Dexec.mainClass=fi.agileo.basic.HelloWorld
echo "*****example: *****"
mvn exec:java -Dexec.mainClass=fi.agileo.basic.BasicVariablesDemo
echo "*****example: *****"
mvn exec:java -Dexec.mainClass=fi.agileo.basic.DateEsim
echo "*****example: *****"
mvn exec:java -Dexec.mainClass=fi.agileo.basic.IhminenTesti
echo "*****example: *****"
mvn exec:java -Dexec.mainClass=fi.agileo.basic.WhileDemo
echo "*****example: *****"
mvn exec:java -Dexec.mainClass=fi.agileo.basic.ForDemo
echo "*****example: *****"
mvn exec:java -Dexec.mainClass=fi.agileo.basic.HelloUtfMerkisto
echo "*****example: *****"
mvn exec:java -Dexec.mainClass=fi.agileo.basic.HelloUtfString
echo "*****example: *****"
mvn exec:java -Dexec.mainClass=fi.agileo.basic.SummaKonsolilta
echo "*****example: *****"
mvn exec:java -Dexec.mainClass=fi.agileo.basic.StringModification
echo "*****example: *****"
mvn exec:java -Dexec.mainClass=fi.agileo.basic.SwitchWithString
echo "*****example: *****"
mvn exec:java -Dexec.mainClass=fi.agileo.basic.IntArraySum
echo "*****example: *****"
mvn exec:java -Dexec.mainClass=fi.agileo.basic.SelectionSortArray
echo "*****example: *****"
mvn exec:java -Dexec.mainClass=fi.agileo.basic.TauluKopiointi