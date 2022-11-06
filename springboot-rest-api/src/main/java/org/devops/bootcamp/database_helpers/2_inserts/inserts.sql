USE springboot_rest_api
GO

INSERT INTO dbo.products ("name", "description", price) VALUES
    ('Pizza', 'Pre fact', 17.5),
    ('Chicken', NULL, 19.5),
    ('Hamburguer', 'Simple', 17.5),
    ('Hamburguer-D', 'Double', 20.3),
    ('Salchipapa', 'Exta papa', 76.3),
    ('Coca Cola', 'Soda', 3.1)
GO

INSERT INTO dbo.orders ("client","total") VALUES
    ('Diego',0),
    ('Sandro',0),
    ('Paulo',0)
GO

INSERT INTO dbo.users("username","password","role") VALUES
    ('bootcamp','$2a$10$ixlPY3AAd4ty1l6E2IsQ9OFZi2ba9ZQE0bP7RFcGIWNhyFrrT3YUi','ROLE_ADMIN'),
    ('diego','$2a$10$KYZrKMhuUtycuX6EU.a/Q.fL.LtRvFP0Y.H5mpHlB0LMsZ23wIHCW','ROLE_USER')
GO
