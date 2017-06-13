/* sql files for MySQL Server*/
/* Initialized DB*/

/*drop database java6;*/
create database if not exists java6;

use java6;

/*DROP TABLE companies Cascade;*/
CREATE TABLE java6.companies(
id INT auto_increment NOT NULL,
name varchar(200) NOT NULL,
fullName varchar(200) NULL,
city varchar(200) NOT NULL,
identificationCode varchar(20) NULL,
PRIMARY KEY(id));

/*DROP TABLE customers Cascade;*/
CREATE TABLE java6.customers (
id INT auto_increment NOT NULL,
name varchar(200) NOT NULL,
identificationCode varchar(20) NULL,
phone varchar(50) NULL,
PRIMARY KEY(id));

/*DROP TABLE developers Cascade;*/
CREATE TABLE java6.developers (
id INT auto_increment NOT NULL,
fullName varchar(200) NOT NULL,
firstName varchar(100) NOT NULL,
surName varchar(100) NOT NULL,
identificationCode varchar(100) NULL,
birthday date NULL,
phone varchar(100) NULL,
salary decimal(15,2) NULL,
PRIMARY KEY(id));

/*DROP TABLE projects Cascade;*/
CREATE TABLE java6.projects (
id INT auto_increment NOT NULL,
name varchar(200) NOT NULL,
cost decimal(15,2) NULL,
PRIMARY KEY(id));

/*DROP TABLE skills Cascade;*/
CREATE TABLE java6.skills (
id INT auto_increment NOT NULL,
name varchar(100) NOT NULL,
PRIMARY KEY(id));

/*DROP TABLE _company_customer Cascade;*/
CREATE TABLE java6._company_customer (
id INT auto_increment NOT NULL,
company INT NOT NULL,
customer INT NOT NULL,
PRIMARY KEY(id),
foreign key (company) references companies(id),
foreign key (customer) references customers(id));

/*DROP TABLE _customer_project Cascade;*/
CREATE TABLE java6._customer_project (
id INT auto_increment NOT NULL,
customer INT NOT NULL,
project INT NOT NULL,
PRIMARY KEY(id),
foreign key (customer) references customers(id),
foreign key (project) references projects(id));

/*DROP TABLE _customerProject_developer Cascade;*/
CREATE TABLE java6._customerProject_developer (
id INT auto_increment NOT NULL,
customerProject INT NOT NULL,
developer INT NOT NULL,
PRIMARY KEY(id),
foreign key (customerProject) references _customer_project(id),
foreign key (developer) references developers(id));

/*DROP TABLE _developer_skill Cascade;*/
CREATE TABLE java6._developer_skill (
id INT auto_increment NOT NULL,
developer INT NOT NULL,
skill INT NOT NULL,
PRIMARY KEY(id),
foreign key (developer) references developers(id),
foreign key (skill) references skills(id));