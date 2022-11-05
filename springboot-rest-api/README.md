# SpringBoot-REST-api

 
## Usage  

To be able to connect the applicaction to a database the running command must include the connection url, username, password and driver class name as follows:
~~~
./gradlew bootRun -PdbUrl='jdbc:sqlserver://localhost:1433;encrypt=false;databaseName=spring_boot_rest_api' -PdbUser=sa -PdbPassword=camilosanz -PdbDriverClass='com.microsoft.sqlserver.jdbc.SQLServerDriver' 
~~~  