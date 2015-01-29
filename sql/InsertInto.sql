INSERT INTO CLIENT (name , prenom, adresse, telephone, inactif)
	VALUES ('chaignepain', 'jennifer', 'mon adresse', '001122334455',0),
	('chaumont', 'thibaut', 'mon adresse', '001122334455',0),
	('delechat', 'william', 'mon adresse', '001122334455',0),
	('laine', 'guillaume', 'mon adresse', '001122334455',0),
	('natulique', 'thierry', 'mon adresse', '001122334455',0),
	('clooney', 'georges', 'mon adresse', '001122334455',0),
	('morel', 'marcel', 'mon adresse', '001122334455',0),
	('mars', 'bruno', 'mon adresse', '001122334455',0),
	('hawgins', 'stephane', 'mon adresse', '001122334455',0),
	('de la jungle', 'geoges', 'mon adresse', '001122334455',0);

INSERT INTO SERVICE (description, prix, type_service)
	VALUES('Shampooing - Coupe homme', 14, 703),
	('Shampooing - Coupe femme - Brushing', 23, 703),
	('Couleur - coupe brushing', 41, 703),
	('Mèches - Shampooing Coupe Brushing', 45, 703),
	('Coupe fille - 14 ans', 13, 703),
	('Coupe garçon - 14 ans', 10, 703),
	('Vente produits', 0, 701);
	
INSERT INTO INTERVENTION (id_client, commentaire, date_intervention, paiement, etat)
	VALUES(1, 'Super', '2014-08-10 15:23:00.123', 0, 0),
	(2, 'Super', '2014-11-15 12:23:00.123', 0, 0),
	(3, 'Super', '2014-12-20 11:23:00.123', 0, 0),
	(4, 'Super', '2015-01-30 13:23:00.123', 0, 1),
	(5, 'Super', '2015-02-15 14:23:00.123', 0, 2),
	(6, 'Super', '2015-02-16 15:23:00.123', 0, 1),
	(7, 'Super', '2015-02-14 14:15:00.123', 0, 1),
	(8, 'Super', '2015-02-10 14:15:00.123', 0, 2),
	(9, 'Super', '2015-02-17 14:15:00.123', 0, 1),
	(10, 'Super', '2015-02-20 14:15:00.123', 0, 2);
	
INSERT INTO SOMME_MONTANT (id_intervention, id_service, prix)
	VALUES (1, 2, 20),
	(2, 1, 10),
	(3, 1, 14),
	(4, 1, 13),
	(5, 1, 12),
	(6, 1, 11),
	(7, 1, 10.5),
	(8, 1, 12.5),
	(9, 1, 11.5),
	(10, 1, 13.5);
	