create table TS_A4_EMPLOYEE (
  id INT NOT NULL auto_increment,
  first_name VARCHAR(20) default NULL,
  last_name VARCHAR(20) default NULL,
  salary INT default NULL,
  PRIMARY KEY (id)
);

create table TS_A4_CERTIFICATE (
  id INT NOT NULL auto_increment,
  certificate_name VARCHAR(30) default NULL,
  PRIMARY KEY (id)
);

create table TS_A4_EMP_CERT (
  employee_id INT NOT NULL,
  certificate_id INT NOT NULL,
  PRIMARY KEY (employee_id,certificate_id)
);