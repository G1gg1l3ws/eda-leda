#!/usr/bin/sh

clear

javac "$1".java -d ../class ;  java -cp ../class "$1"
