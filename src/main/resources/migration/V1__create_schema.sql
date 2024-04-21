CREATE SCHEMA IF NOT EXISTS homework;

CREATE TABLE sectors
(
    id        INT PRIMARY KEY,
    name      VARCHAR(255),
    parent_id INT,
    FOREIGN KEY (parent_id) REFERENCES sectors (id)
);
