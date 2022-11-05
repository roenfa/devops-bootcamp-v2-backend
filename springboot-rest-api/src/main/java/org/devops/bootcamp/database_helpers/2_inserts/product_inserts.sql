USE springboot_rest_api
GO

INSERT INTO products ("name", "description", price) VALUES
    ('Pizza', 'Pre fact', 17.5),
    ('Chicken', NULL, 19.5),
    ('Hamburguer', 'Simple', 17.5),
    ('Hamburguer-D', 'Double', 20.3),
    ('Salchipapa', 'Exta papa', 76.3),
    ('Coca Cola', 'Soda', 3.1)
GO

SELECT * FROM dbo.products
GO
