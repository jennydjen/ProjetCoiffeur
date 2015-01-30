CREATE TABLE operation(
	id bigint not null generated always AS IDENTITY constraint id_pkoperation Primary key, 
	"date" TIMESTAMP,
	"type" int,
	description varchar(250),
	type_paiment int,
	numeroFacture varchar(250),
	id_client bigint,
	prix double,
	numeroCheque varchar(250),
	nomBanque varchar (250),
	CONSTRAINT fk_clientOperation FOREIGN KEY (id_client) REFERENCES Client(id)
);