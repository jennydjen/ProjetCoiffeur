create table somme_montant(
	id bigint not null generated always AS IDENTITY constraint id_pksomme_montant Primary key,
	id_intervention bigint,
	id_service bigint,
	prix double, 
	CONSTRAINT fk_intervention FOREIGN KEY (id_intervention) REFERENCES Intervention(id),
	CONSTRAINT fk_service FOREIGN KEY (id_service) REFERENCES Service(id));
