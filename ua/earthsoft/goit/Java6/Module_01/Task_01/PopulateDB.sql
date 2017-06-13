/* sql files for MySQL Server*/
/* Populate DB*/

INSERT INTO companies (name, fullName, City, identificationCode) VALUES
("EarthSoft KYIV", "EarthSoft KYIV Ltd.", "KYIV", "04557876"),
("EarthSoft ODESSA", "EarthSoft ODESSA Ltd.", "ODESSA", "04326955");

INSERT INTO customers (name,identificationCode, phone) VALUES
("Siemens","64837645","+380442000202"),
("Deutsche Bank","98798754","+380442000303"),
("BNP PARIBAS","35542436","+380442000404"),
("AXA","87686994","+380442000505"),
("Volkswagen AG","45724743","+380442000606");

INSERT INTO projects (name, cost) VALUES
("Prepare", 12000.00),
("Validate", 8000.00),
("Verification", 15000.00),
("Import data (old period)", 48000.00),
("Import data (current period)", 19000.00),
("Close period", 10000.00),
("Move to test", 5600.00),
("Refactor code", 1000.00),
("Registration of incident", 2000.00),
("Close of incident", 2000.00),
("Presentation", 3000.00);

INSERT INTO developers (fullName, firstName, surName, identificationCode, birthday, phone, salary) VALUES
("Oleg Kabysh", "Oleg", "Kabysh", "6583246864", '1984-04-04', "+380670001111", 1000.50),
("Andrey Tramon", "Andrey", "Tramon", "9849363687", '1983-03-03', "+380670002222", 1500.60),
("Anton Lifyrenko", "Anton", "Lifyrenko", "3984735375", '1982-02-02', "+380670003333", 2000.70),
("Volodymyr Tkachuk", "Volodymyr", "Tkachuk", "3749874635", '1981-01-01', "+380670004444", 2500.99);

INSERT INTO skills (name) VALUES("Java Core"),
("Spring framework"), ("Hibernate framework"), ("Web Service"),
("SQL"), ("JDBC"), ("JPA"), ("JSP/Servlets"), ("OOP"),
("JavaScript"), ("CSS"), ("Design Patterns");

INSERT INTO _company_customer (company, customer) VALUES
(1, 1), (1, 3), (1, 5),
(2, 1), (2, 2), (2, 3), (2, 4), (2, 5);

INSERT INTO _customer_project (customer, project) VALUES
(1, 1), (1, 3), (1, 5), (1, 6), (1, 7), (1, 9),
(2, 1), (2, 2), (2, 9), (2, 10), (2, 11), (2, 6),
(3, 2), (3, 7), (3, 8), (3, 3), (3, 10),
(4, 1), (4, 2), (4, 5), (4, 6),
(5, 3), (5, 5), (5, 7), (5, 9);

INSERT INTO _customerProject_developer (customerProject, developer) VALUES
(1, 1), (1, 2)
(2, 4),
(3, 4), (3, 2),
(4, 2),
(5, 1), (5, 2),
(6, 3),
(7, 3), (7, 2),
(8, 3),
(9, 4), (9, 2),
(10, 4),
(11, 4), (11, 2),
(12, 3),
(13, 3), (13, 1),
(14, 4),
(15, 3), (15, 2),
(16, 3),
(17, 4), (17, 2),
(18, 3),
(19, 3), (19, 2),
(20, 2),
(21, 3), (21, 1),
(22, 2),
(23, 3), (23, 2),
(24, 3),
(25, 2) (25, 1);

INSERT INTO _developer_skill (developer, skill) VALUES
(1, 1), (1, 5), (1, 9),
(2, 1), (2, 3), (2, 5), (2, 9),
(3, 1), (3, 4), (3, 7), (3, 8), (3, 10), (3, 11),
(4, 1), (4, 2), (4, 3), (4, 4), (4, 5), (4, 6), (4, 7), (4, 8), (4, 9), (4, 10), (4, 11), (4, 12);