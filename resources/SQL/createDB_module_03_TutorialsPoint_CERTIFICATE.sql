use Java6;
create table ts_certificate
(
	id int NOT NULL auto_increment
		primary key,
	certificate_name varchar(30) DEFAULT null,
	emloyee_id int DEFAULT null
)
;