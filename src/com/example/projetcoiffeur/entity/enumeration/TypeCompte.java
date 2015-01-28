package com.example.projetcoiffeur.entity.enumeration;

public enum TypeCompte {
	// DEPENSES
	// Depense de type Achat
	MATIERE_PREMIERE_FOURNITURE (601),
	FOURNITURES_NON_STOCKAGE (6061),
	FOURNITURES_ENTRETIEN(6063),
	AUTRE_FOURNITURES(6068),
	ACHAT_ETURE_PRESTATION_SERVICE(604),
	ACHAT_DE_MARCHANDISES(607),
	// Depense de type Service Exterieures
	SOUS_TRAITANCE_GENERAL(611),
	LOCATIONS(613),
	ENTRETIEN_REPARATION(615),
	ASSURANCE(616),
	DOCUMENTATION(6181),
	DIVERS(618),
	// Depense de type Autre service exterieurs
	RENUMERATION_INTERMEDIAIRE_HONORAIRE(622),
	PUBLICITE_PUBLICATION_RELATION_PUBLIQUES(623),
	DEPLACEMENT_MISSIONS_RECEPTION(625),
	FRAIS_POSTAUX_FRAI_TELECOMMUNICATION(626),
	SERVICES_BANCAIRES_AUTRE(627),
	// Depense de type Impots taxes et versement assimilés
	IMPOTS_TAXE_RENUMERATION(631),
	AUTRE_IMPOTS_TAXE(635),
	// Depense de type Charges de personnel
	RENUMERATION_DU_PERSONNEL(641),
	CHARGES_SECURITE_SOCIALE(645),
	AUTRES_CHARGES_PERSONNEL(647),
	// Depense de type Autre charges de gestion courante
	DROITS_AUTEURS_REPRODUCTION(6516),
	COTISATIONS(6586),
	// Depense de type Emplois des contributions volontaires en nature
	SECOURS_NATURE(861),
	MISE_DISPOSITION_GRATUIRE_BIEN_SERVICE(862),
	PERSONNEL_BENEVOLE(863),
	
	// RECETTES
	// Recette de type Ventes
	VENTE_MARCHANDISES(701),
	VENTE_PRODUITS_FINIS(702),
	VENTE_PRESTATION_SERVICE(703),
	// Recette de type Subventions d'exploitation
	ETAT(741),
	REGION(742),
	DEPARTEMENT(743),
	COMMUNES(744),
	ORGANISMES_SOCIAUX(745),
	EUROPE(746),
	CNASEA(747),
	AUTRES_SUBVENTIONS(748),
	// Recette de type Autre produits de gestion courante,
	COLLECTE(754),
	COTISATION(756),
	// Recette de type Contributions volontaires en nature
	BENEVOLAT(871),
	PRESTATIONS_NATURE(872),
	DONS_NATURE(873);
	
	private int id_compte;
	
	private TypeCompte(int compte) {
		this.id_compte = compte;
	}
	
	public boolean isRecette(){
		boolean result;
		switch(this){		
		// RECETTES
		// Recette de type Ventes
		case VENTE_MARCHANDISES:
		case VENTE_PRODUITS_FINIS:
		case VENTE_PRESTATION_SERVICE:
		// Recette de type Subventions d'exploitation
		case ETAT:
		case REGION:
		case DEPARTEMENT:
		case COMMUNES:
		case ORGANISMES_SOCIAUX:
		case EUROPE:
		case CNASEA:
		case AUTRES_SUBVENTIONS:
		// Recette de type Autre produits de gestion courante,
		case COLLECTE:
		case COTISATION:
		// Recette de type Contributions volontaires en nature
		case BENEVOLAT:
		case PRESTATIONS_NATURE:
		case DONS_NATURE:
			result = true;
			break;
		default:
			result = false;
			break;
		}
		
		return result;
	}
	
	public int getId_compte() {
		return id_compte;
	}
}
