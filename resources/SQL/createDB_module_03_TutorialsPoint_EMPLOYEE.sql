use Java6;
create table ts_employee
(
	id int auto_increment
		primary key,
	first_name varchar(20) not null,
	last_name varchar(20) not null,
	salary int not null
)
;