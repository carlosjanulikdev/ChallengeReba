--1. Create Schema
CREATE SCHEMA `reba` DEFAULT CHARACTER SET utf8 ;

--2. Create Tables
CREATE TABLE `reba`.`document_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `reba`.`country` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `reba`.`person` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(100) NULL,
  `phone` VARCHAR(100) NULL,
  `email` VARCHAR(75) NULL,
  `age` INT NOT NULL,
  `document_type_id` INT NOT NULL,
  `document_number` INT NOT NULL,
  `country_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (document_type_id) REFERENCES document_type(id),
  FOREIGN KEY (country_id) REFERENCES country(id),
  UNIQUE KEY `person_unique_fields` (`document_type_id`, `document_number`, `country_id` )
);

--3. Inserts of countries
insert into reba.country (id, name) values (1, 'Argentina');
insert into reba.country (id, name) values (2, 'Brasil');
insert into reba.country (id, name) values (3, 'Chile');
insert into reba.country (id, name) values (4, 'Paraguay');
insert into reba.country (id, name) values (5, 'Uruguay');

--4. Inserts of document types
insert into reba.document_type (id, description) values (1, 'DNI');
insert into reba.document_type (id, description) values (2, 'Pasaporte nacional');
insert into reba.document_type (id, description) values (3, 'Tarjeta de residencia');

--5. Create table level 2
CREATE TABLE `reba`.`relationship` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `person_id_1` INT NOT NULL,
  `person_id_2` INT NOT NULL,
  `type` VARCHAR(100) NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (person_id_1) REFERENCES person(id),
  FOREIGN KEY (person_id_2) REFERENCES person(id),
  UNIQUE KEY `relationship_unique_fields` (`person_id_1`, `person_id_2` )
);
