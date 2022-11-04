-- DATABASE STRUCTURE
CREATE DATABASE springboot_rest_api
GO

USE springboot_rest_api
GO

CREATE TABLE orders(
    orderId INT PRIMARY KEY IDENTITY(1,1),
    total FLOAT,
    client VARCHAR(200) NOT NULL
)
GO

DROP TABLE IF EXISTS dbo.products 
GO

CREATE TABLE products(
    productoId INT PRIMARY KEY IDENTITY(1,1),
    "name" VARCHAR(200) NOT NULL,
    "description" VARCHAR(200) NULL,
    price FLOAT
)
GO