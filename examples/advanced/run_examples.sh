#!/bin/bash
echo "Running Java Advanced examples with Maven"

mvn clean compile 

echo "***Futures***"
mvn exec:java -Dexec.mainClass=fi.agileo.concurrent.UsingCallables
mvn exec:java -Dexec.mainClass=fi.agileo.concurrent.SimpleExecutorServiceDemo
mvn exec:java -Dexec.mainClass=fi.agileo.concurrent.StrLengthCallable


echo "****JavaFX examples ****"
mvn exec:java -Dexec.mainClass=fi.agileo.fxdemos.NaytaLehtiSolmu
mvn exec:java -Dexec.mainClass=fi.agileo.fxdemos.LabelsDemo
mvn exec:java -Dexec.mainClass=fi.agileo.fxdemos.SceneGraphStructure
mvn exec:java -Dexec.mainClass=fi.agileo.fxdemos.JavaFXSimplePaint
mvn exec:java -Dexec.mainClass=fi.agileo.fxdemos.JavaFxCollectionExample
mvn exec:java -Dexec.mainClass=fi.agileo.fxdemos.ListDemo
mvn exec:java -Dexec.mainClass=fi.agileo.fxdemos.LayoutTest
mvn exec:java -Dexec.mainClass=fi.agileo.fxdemos.PainikkeenTapahtumanKasittely
mvn exec:java -Dexec.mainClass=fi.agileo.fxdemos.Animointi

echo "*****example: *****"
mvn exec:java -Dexec.mainClass=fi.agileo.advanced.LueTekstitiedosto
echo "*****example: *****"
mvn exec:java -Dexec.mainClass=fi.agileo.advanced.TekstiTiedostoOperaatiot
echo "*****example: *****"
mvn exec:java -Dexec.mainClass=fi.agileo.advanced.TallennaAnkatTeksti
echo "*****example: *****"
mvn exec:java -Dexec.mainClass=fi.agileo.advanced.TallennaAnkatOlio
echo "*****example: *****"
mvn exec:java -Dexec.mainClass=fi.agileo.advanced.ListaaHakemisto
echo "*****example: *****"
mvn exec:java -Dexec.mainClass=fi.agileo.advanced.SaveAndReadPersons
echo "*****example: *****"
mvn exec:java -Dexec.mainClass=fi.agileo.advanced.WriteAndReadBinaryData

echo "*****example: *****"
mvn exec:java -Dexec.mainClass=fi.agileo.concurrent.SaieLaskuri
echo "*****example: *****"
mvn exec:java -Dexec.mainClass=fi.agileo.concurrent.SaieLopetus
echo "*****example: *****"
mvn exec:java -Dexec.mainClass=fi.agileo.concurrent.SaieSynkronointi

