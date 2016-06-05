TRUNCATE TABLE tachkischema."Cars" RESTART IDENTITY CASCADE;
TRUNCATE TABLE tachkischema."Brand" RESTART IDENTITY CASCADE;

INSERT INTO tachkischema."Brand" (id, brand) VALUES (1, 'AUDI');
INSERT INTO tachkischema."Brand" (id, brand) VALUES (2, 'BMW');
INSERT INTO tachkischema."Brand" (id, brand) VALUES (3, 'VW');
INSERT INTO tachkischema."Brand" (id, brand) VALUES (4, 'Mercedes');
INSERT INTO tachkischema."Brand" (id, brand) VALUES (5, 'Renault');
INSERT INTO tachkischema."Brand" (id, brand) VALUES (6, 'Lada');
INSERT INTO tachkischema."Brand" (id, brand) VALUES (7, 'Honda');


INSERT INTO tachkischema."Cars" (id, model, color, price, brand_id)
VALUES (1, 'Q7', 'red', 30000, 1);
INSERT INTO tachkischema."Cars" (id, model, color, price, brand_id)
VALUES (2, 'TT', 'black', 26000, 1);
INSERT INTO tachkischema."Cars" (id, model, color, price, brand_id)
VALUES (3, 'X5', 'blue', 43000, 2);
INSERT INTO tachkischema."Cars" (id, model, color, price, brand_id)
VALUES (4, 'X3', 'white', 18000, 2);
INSERT INTO tachkischema."Cars" (id, model, color, price, brand_id)
VALUES (5, 'Jetta', 'green', 16000, 3);
INSERT INTO tachkischema."Cars" (id, model, color, price, brand_id)
VALUES (6, 'CC', 'grey', 23000, 3);
INSERT INTO tachkischema."Cars" (id, model, color, price, brand_id)
VALUES (7, 'CLK', 'black', 19000, 4);
INSERT INTO tachkischema."Cars" (id, model, color, price, brand_id)
VALUES (8, '600', 'white', 9000, 4);
INSERT INTO tachkischema."Cars" (id, model, color, price, brand_id)
VALUES (9, 'kengoo', 'red', 8500, 5);
INSERT INTO tachkischema."Cars" (id, model, color, price, brand_id)
VALUES (10, 'logan', 'red', 6000, 5);
INSERT INTO tachkischema."Cars" (id, model, color, price, brand_id)
VALUES (11, '2108', 'red', 3000, 6);
INSERT INTO tachkischema."Cars" (id, model, color, price, brand_id)
VALUES (12, 'samara', 'red', 3700, 6);
INSERT INTO tachkischema."Cars" (id, model, color, price, brand_id)
VALUES (13, 'CR-V', 'red', 15800, 7);
INSERT INTO tachkischema."Cars" (id, model, color, price, brand_id)
VALUES (14, 'accord', 'red', 9000, 7);
INSERT INTO tachkischema."Cars" (id, model, color, price, brand_id)
VALUES (15, 'civik', 'red', 6000, 7);