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

/*DROP TABLE mtm_company_customer Cascade;*/
CREATE TABLE java6.mtm_company_customer (
company INT NOT NULL,
customer INT NOT NULL,
PRIMARY KEY(company, customer),
foreign key (company) references companies(id),
foreign key (customer) references customers(id));

/*DROP TABLE mtm_customer_project Cascade;*/
CREATE TABLE java6.mtm_customer_project (
customer INT NOT NULL,
project INT NOT NULL,
PRIMARY KEY(customer, project),
foreign key (customer) references customers(id),
foreign key (project) references projects(id));

/*DROP TABLE mtm_customer_project_developer Cascade;*/
CREATE TABLE java6.mtm_customer_project_developer (
customer INT NOT NULL,
project INT NOT NULL,
developer INT NOT NULL,
PRIMARY KEY(customer, project, developer),
foreign key (customer) references mtm_customer_project(customer),
foreign key (project) references mtm_customer_project(project),
foreign key (developer) references developers(id));

/*DROP TABLE mtm_developer_skill Cascade;*/
CREATE TABLE java6.mtm_developer_skill (
developer INT NOT NULL,
skill INT NOT NULL,
PRIMARY KEY(developer, skill),
foreign key (developer) references developers(id),
foreign key (skill) references skills(id));