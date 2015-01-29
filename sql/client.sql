create table Client(
	id bigint not null generated always AS IDENTITY constraint id_pk Primary key, 
	name varchar(250), 
	prenom varchar(250), 
	adresse varchar(250), 
	telephone int, 
	inactif int);
	
ALTER TABLE Client DROP COLUMN inactif;
ALTER TABLE Client ADD COLUMN inactif int; 

ALTER TABLE Client DROP COLUMN telephone;
ALTER TABLE Client ADD COLUMN telephone varchar(20); 