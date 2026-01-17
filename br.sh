#!/bin/bash

# build and run

javac -cp src/lib/ojdbc17.jar:src/lib/designgridlayout-1.11.jar:src/lib/flatlaf-3.6.2.jar:src/lib/LGoodDatePicker-11.2.1.jar:src/lib/miglayout-swing-4.2.jar:src/lib/miglayout-core-4.2.jar:src/lib/flatlaf-extras-3.6.2.jar -d bin $(find src/ -name "*.java") 

if [ $? -ne 0 ]; then
    echo ""
    echo "Compilation échouée ! Exécution annulée."
    exit 1
fi
# Après la compilation
# mkdir -p bin/ressource
# cp -r src/ressource/* bin/ressource/

echo " "
echo "..."
echo ">>"
echo " "

java -cp bin:src/lib/ojdbc17.jar:src/lib/designgridlayout-1.11.jar:src/lib/flatlaf-3.6.2.jar:src/lib/LGoodDatePicker-11.2.1.jar:src/lib/miglayout-swing-4.2.jar:src/lib/miglayout-core-4.2.jar:src/lib/flatlaf-extras-3.6.2.jar src.main.Main