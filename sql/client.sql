create table Client(
	id bigint not null generated always AS IDENTITY constraint id_pk Primary key, 
	name varchar(250), 
	prenom varchar(250), 
	adresse varchar(250), 
	telephone int, 
	inactif boolean); 