-- DATABASE STRUCTURE
DROP DATABASE IF EXISTS springboot_rest_api
GO

CREATE DATABASE springboot_rest_api

USE springboot_rest_api
GO

DROP TABLE IF EXISTS dbo.order_product 
GO
DROP TABLE IF EXISTS dbo.orders 
GO
DROP TABLE IF EXISTS dbo.products 
GO
DROP TABLE IF EXISTS dbo.users 
GO

CREATE TABLE dbo.orders(
    order_id BIGINT PRIMARY KEY IDENTITY(1,1),
    total FLOAT,
    client VARCHAR(200) NOT NULL
)
GO
CREATE TABLE dbo.products(
    product_id BIGINT PRIMARY KEY IDENTITY(1,1),
    "name" VARCHAR(200) NOT NULL,
    "description" VARCHAR(200) NULL,
    price FLOAT
)
GO
CREATE TABLE dbo.order_product(
    order_id BIGINT,
    product_id BIGINT,
    FOREIGN KEY (order_id) REFERENCES dbo.orders(order_id),
    FOREIGN KEY (product_id) REFERENCES dbo.products(product_id)
)
GO
CREATE TABLE dbo.users(
    user_id BIGINT PRIMARY KEY IDENTITY(1,1),
    username VARCHAR(45) UNIQUE,
    "password" VARCHAR(64),
    "role" VARCHAR(45)
    -- "enabled" TINYINT(4)
)
GO