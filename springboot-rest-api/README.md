# Introduction

## Database Connection

<ins>Pre requisits</ins>

Docker daemon needs to be initiated

<ins>Docker Up</ins>

Gradle now has a build functionality for docker Sql Server (_Database connection_)

```shell
.\gradlew composeUp --info
```

- **--info**: To check log messages

## [Database Helper Folder](src/main/database_helpers/)

Database folder contains:

- [database_structure](src/main/database_helpers/1_database_structure/database_structure.sql): Structure of DB
- [inserts](src/main/database_helpers/2_inserts/inserts.sql): First inserts for tests
- [selects](src/main/database_helpers/3_selects/select_all_tables.sql): Select to check database