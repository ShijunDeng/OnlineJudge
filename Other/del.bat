for /r . %%a in (.) do @if exist "%%a\.class" rd /s /q "%%a\.class" 
for /r . %%a in (.) do @if exist "%%a\.svn" rd /s /q "%%a\.svn" 
for /r . %%a in (.) do @if exist "%%a\.settings" rd /s /q "%%a\.settings" 
