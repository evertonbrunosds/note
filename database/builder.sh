#!/bin/bash

if [ -f assembled.sql ]; then
    rm assembled.sql
fi

file_names=("imports.sql" "enums.sql" "database.sql" "indexes.sql")

for file in "${file_names[@]}"; do
    echo "/* ---> $file <--- */" >> assembled.sql
    cat "source/$file" >> assembled.sql
    echo >> assembled.sql
done
