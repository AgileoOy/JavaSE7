#!/bin/bash 
echo "Running Java Object-Oriented examples with Maven" 
mvn clean compile  
echo "*****example: StaticMethodsDemo*****" 
#mvn exec:java -Dexec.mainClass=fi.agileo.object.StaticMethodsDemo 
echo "*****example: IhminenTesti *****" 
#mvn exec:java -Dexec.mainClass=fi.agileo.object.IhminenTesti 
echo "*****example: Koira*****" 
#mvn exec:java -Dexec.mainClass=fi.agileo.object.Koira 
echo "*****example:  *****" 
#mvn exec:java -Dexec.mainClass=fi.agileo.object.SuorakulmioDemo 
echo "*****example: Sarjakuva *****"
#mvn exec:java -Dexec.mainClass=fi.agileo.object.Sarjakuva 
echo "*****example: Sarjakuva2 *****"
mvn exec:java -Dexec.mainClass=fi.agileo.object.Sarjakuva2
echo "*****example: Koosteluokka *****"
mvn exec:java -Dexec.mainClass=fi.agileo.object.Koosteluokka
echo "*****example: KoostaminenTesti *****"
mvn exec:java -Dexec.mainClass=fi.agileo.object.KoostaminenTesti

echo "*****example: RuntimePoikkeus *****"
mvn exec:java -Dexec.mainClass=fi.agileo.object.RuntimePoikkeus
echo "*****example: OwnExceptionDemo *****"
mvn exec:java -Dexec.mainClass=fi.agileo.object.OwnExceptionDemo