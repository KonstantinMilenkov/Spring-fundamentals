INSERT INTO users( active, email, first_name, last_name, password)
VALUES
    (1,'admin@example.com', 'Admin', 'Adminov', '192371985asda');

INSERT INTO `brands`(id, `name`)
VALUES
    (1,'Toyota'),
    (2,'Ford');

INSERT INTO `models`(id, category, brand_id, name)
VALUES
    (1,'Car',1,'Camry'),
    (2,'Car',1,'Corolla'),
    (3,'Car',2,'Focus'),
    (4,'Car',2,'Fiesta');