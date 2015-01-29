CREATE TABLE Service (
	id bigint not null generated always AS IDENTITY constraint id_pkService Primary key,
	description varchar(50), 
	prix double, 
	type_service int);   
	
	ALTER table Service add column etat int; 