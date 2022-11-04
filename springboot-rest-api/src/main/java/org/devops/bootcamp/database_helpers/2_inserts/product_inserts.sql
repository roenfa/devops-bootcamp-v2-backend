USE springboot_rest_api
GO

INSERT INTO products ("name", "description", price) VALUES
    ('Pizza', 'Pre fact', 17.5),
    ('Chicken', NULL, 19.5),
    ('Hamburguer', 'Simple', 17.5)
GO

SELECT * FROM dbo.products
GO
