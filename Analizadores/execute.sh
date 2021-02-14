#! /bin/bash 
echo "STARTING COMPILING"
cd ./Analizadores
java -jar jflex-full-1.8.2.jar lexer.jflex
java -jar java-cup-11b.jar -parser Parser -symbols sym parser.cup