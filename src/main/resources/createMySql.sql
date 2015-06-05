CREATE TABLE testdb.customer
(
  id INT PRIMARY KEY NOT NULL,
  first_name VARCHAR(50),
  last_name VARCHAR(50)
)CHARACTER set utf8;
ALTER TABLE testdb.customer ADD CONSTRAINT unique_id UNIQUE (id);

CREATE TABLE testdb.adress
(
  id INT PRIMARY KEY NOT NULL,
  street VARCHAR(50),
  city VARCHAR(50),
  FOREIGN KEY (id) REFERENCES customer(id)
)CHARACTER set utf8;
ALTER TABLE testdb.adress ADD CONSTRAINT unique_id UNIQUE (id);

CREATE TABLE testdb.phone_number
(
  id INT PRIMARY KEY NOT NULL,
  type VARCHAR(50),
  num VARCHAR(50),
  id_customer INT,
  FOREIGN KEY (id_customer) REFERENCES customer(id)
)CHARACTER set utf8;
ALTER TABLE testdb.phone_number ADD CONSTRAINT unique_id UNIQUE (id);





