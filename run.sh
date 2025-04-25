#!/bin/bash

# Limpa e recria a pasta out
rm -rf out
mkdir -p out

echo "Compilando arquivos..."
javac -d out/ $(find src -name "*.java")

# Verifica se a compilação deu certo
if [ $? -eq 0 ]; then
    echo "Compilado com sucesso!"
    echo "Executando o programa..."
    java -cp out application.Program
else
    echo "Erro na compilação."
fi
