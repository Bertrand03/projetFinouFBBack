--liquibase formatted sql

--changeset Bertrand:2
CREATE TABLE matableensql (id INT NOT NULL, name VARCHAR(50) NOT NULL, active BIT(1) DEFAULT 1 NULL,
CONSTRAINT PK_MATABLEensql PRIMARY KEY (id));