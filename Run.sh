#!/bin/bash

#Simulacion/nbproject/project.properties
#https://foojay.io/

cd SimulacionMMU
ant -Dplatforms.Oracle_OpenJDK_17.0.2_8.home=/lib/jvm/java-17 jar
ant run -Dplatforms.Oracle_OpenJDK_17.0.2_8.home=/lib/jvm/java-17 jar

exit


