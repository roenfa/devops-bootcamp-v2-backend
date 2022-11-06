IF NOT EXISTS (SELECT * FROM sysdatabases WHERE (name = 'spring_boot_rest_api')) 
    CREATE DATABASE spring_boot_rest_api
GO

DROP DATABASE spring_boot_rest_api  
GO 