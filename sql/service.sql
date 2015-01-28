CREATE TABLE Service (
	id bigint not null generated always AS IDENTITY constraint id_pk Primary key,
	description varchar(50), 
	prix double, 
	type_service int);  