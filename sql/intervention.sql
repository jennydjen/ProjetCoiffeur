create table Intervention(
	id bigint not null generated always AS IDENTITY constraint id_pkintervention Primary key, 
	id_client bigint,
	commenaire varchar(250), 
	date_intervention TIMESTAMP, 
	paiement int,  
	etat int,
	CONSTRAINT fk_client FOREIGN KEY (id_client) REFERENCES Client(id));
	
ALTER TABLE Intervention ADD COLUMN etat int;
ALTER TABLE Intervention DROP COLUMN date_intervention;
ALTER TABLE Intervention ADD COLUMN date_intervention TIMESTAMP; 