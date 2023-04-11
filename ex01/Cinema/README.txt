# I am using Java 8

# Before running the web application, you need to create the database and tables using src/main/resources/sql/schema.sql

# I am using SQLite

# To create a database use the command

# touch /Users/${USER}/test.db

# The default path to the database is /Users/${USER}/test.db. It can be changed in the src/main/webapp/WEB-INF/application.properties file

# Connect to database /Users/${USER}/test.db and run src/main/resources/sql/schema.sql (run src/main/resources/sql/data.sql to add data to database)

# To run the web application, you must use the command

mvn clean install

# To open a website from the console, use the command

open http://localhost:8080

# Then to run the web application, use the command

# mvn cargo:run

# You are using the clean command, which will delete all previously compiled Java

# mvn clean