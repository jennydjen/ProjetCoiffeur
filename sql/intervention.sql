create table Intervention(
	id bigint not null generated always AS IDENTITY constraint id_pkintervention Primary key, 
	id_client bigint,
	commenaire varchar(250), 
	date_intervention DATE, 
	paiement int,  
	etat int,
	CONSTRAINT fk_client FOREIGN KEY (id_client) REFERENCES Client(id));
	
ALTER TABLE Intervention ADD COLUMN etat int;