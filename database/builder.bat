@echo off
setlocal

if exist assembled.sql (
    del assembled.sql
)

set "file_names=imports.sql enums.sql database.sql indexes.sql"

for %%f in (%file_names%) do (
    echo /* ---> %%f <--- */ >> assembled.sql
    type "source\%%f" >> assembled.sql
    echo. >> assembled.sql
)

endlocal
