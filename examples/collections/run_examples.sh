#!/bin/bash
echo "Running Java collection examples with Maven"

mvn clean compile 
echo "*****example: *****"
mvn exec:java -Dexec.mainClass=fi.agileo.collection.ArrayListIterointiVanha
echo "*****example: *****"
mvn exec:java -Dexec.mainClass=fi.agileo.collection.ArrayListIterointiUusi
echo "*****example: *****"
mvn exec:java -Dexec.mainClass=fi.agileo.collection.HashTreeSetExample
echo "*****example: PrintCollection *****"
mvn exec:java -Dexec.mainClass=fi.agileo.collection.PrintCollection
echo "*****example: SingleGeneric *****"
mvn exec:java -Dexec.mainClass=fi.agileo.collection.SingleGeneric
echo "*****example: IteratorDemo *****"
mvn exec:java -Dexec.mainClass=fi.agileo.collection.IteratorDemo
echo "*****example: KansainvalinenEsimerkki *****"
mvn exec:java -Dexec.mainClass=fi.agileo.collection.KansainvalinenEsimerkki
echo "*****example: LokaaliOletukset *****"
mvn exec:java -Dexec.mainClass=fi.agileo.collection.LokaaliOletukset
echo "*****example: CollectionPerusmetodit *****"
mvn exec:java -Dexec.mainClass=fi.agileo.collection.CollectionPerusmetodit
echo "*****example: CollectionPerusmetodit *****"
mvn exec:java -Dexec.mainClass=fi.agileo.collection.GeneerinenTyyppi

echo "*****example: CollectionPerusmetodit *****"
mvn exec:java -Dexec.mainClass=fi.agileo.collection.OlionReflektointi