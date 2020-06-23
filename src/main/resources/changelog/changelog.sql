--liquibase formatted sql

--changeset Bertrand:1
CREATE TABLE matabletest (id INT NOT NULL, name VARCHAR(50) NOT NULL, active BIT(1) DEFAULT 1 NULL,
CONSTRAINT PK_MATABLETEST PRIMARY KEY (id));