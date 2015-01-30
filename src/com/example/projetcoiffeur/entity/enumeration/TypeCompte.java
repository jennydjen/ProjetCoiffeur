package com.example.projetcoiffeur.entity.enumeration;

import java.util.LinkedList;
import java.util.List;

public enum TypeCompte {
	// DEPENSES
	// Depense de type Achat
	MATIERE_PREMIERE_FOURNITURE(601), 
	FOURNITURES_NON_STOCKAGE(6061), 
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

	public boolean isRecette() {
		boolean result;
		switch (this) {
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

	@Override
	public String toString() {
		String result = "";
		switch (this) {
		// DEPENSES
		// Depense de type Achat
		case MATIERE_PREMIERE_FOURNITURE:
			result = "Matières premières – Fournitures";
			break;
		case FOURNITURES_NON_STOCKAGE:
			result = "Fournitures non stockables (eau, électricité)";
			break;
		case FOURNITURES_ENTRETIEN:
			result = "Fournitures d'entretien et de petit équipement";
			break;
		case AUTRE_FOURNITURES:
			result = "Autres fournitures";
			break;
		case ACHAT_ETURE_PRESTATION_SERVICE:
			result = "Achat d'étude et de prestation de service";
			break;
		case ACHAT_DE_MARCHANDISES:
			result = "Achats de marchandises";
			break;
		// Depense de type Service Exterieures
		case SOUS_TRAITANCE_GENERAL:
			result = "Sous traitance générale";
			break;
		case LOCATIONS:
			result = "Locations";
			break;
		case ENTRETIEN_REPARATION:
			result = "Entretien et réparation";
			break;
		case ASSURANCE:
			result = "Assurance";
			break;
		case DOCUMENTATION:
			result = "Documentation";
			break;
		case DIVERS:
			result = "Divers";
			break;
		// Depense de type Autre service exterieurs
		case RENUMERATION_INTERMEDIAIRE_HONORAIRE:
			result = "Rémunération d'intermédiaires et honoraires";
			break;
		case PUBLICITE_PUBLICATION_RELATION_PUBLIQUES:
			result = "Publicité, publication et relations publiques";
			break;
		case DEPLACEMENT_MISSIONS_RECEPTION:
			result = "Déplacements, missions et réception";
			break;
		case FRAIS_POSTAUX_FRAI_TELECOMMUNICATION:
			result = "Frais postaux et frais de télécommunication";
			break;
		case SERVICES_BANCAIRES_AUTRE:
			result = "Services bancaires, autres";
			break;
		// Depense de type Impots taxes et versement assimilés
		case IMPOTS_TAXE_RENUMERATION:
			result = "Impôts et taxes sur rémunération";
			break;
		case AUTRE_IMPOTS_TAXE:
			result = "Autres impôts et taxes";
			break;
		// Depense de type Charges de personnel
		case RENUMERATION_DU_PERSONNEL:
			result = "Rémunération du personnel";
			break;
		case CHARGES_SECURITE_SOCIALE:
			result = "Charges de sécurité sociale";
			break;
		case AUTRES_CHARGES_PERSONNEL:
			result = "Autres charges de personnel";
			break;
		// Depense de type Autre charges de gestion courante
		case DROITS_AUTEURS_REPRODUCTION:
			result = "Droits d'auteurs et de reproduction (SACEM)";
			break;
		case COTISATIONS:
			result = "Cotisations (liées à la vie statutaire)";
			break;
		// Depense de type Emplois des contributions volontaires en nature
		case SECOURS_NATURE:
			result = "Secours en nature";
			break;
		case MISE_DISPOSITION_GRATUIRE_BIEN_SERVICE:
			result = "Mise à disposition gratuite de biens et services";
			break;
		case PERSONNEL_BENEVOLE:
			result = "Personnel bénévole";
			break;

		// RECETTES
		// Recette de type Ventes
		case VENTE_MARCHANDISES:
			result = "Ventes de marchandises";
			break;
		case VENTE_PRODUITS_FINIS:
			result = "Ventes de produits finis";
			break;
		case VENTE_PRESTATION_SERVICE:
			result = "Ventes de prestation de service";
			break;
		// Recette de type Subventions d'exploitation
		case ETAT:
			result = "Etat";
			break;
		case REGION:
			result = "Région";
			break;
		case DEPARTEMENT:
			result = "Département";
			break;
		case COMMUNES:
			result = "Communes";
			break;
		case ORGANISMES_SOCIAUX:
			result = "Organismes sociaux";
			break;
		case EUROPE:
			result = "Europe";
			break;
		case CNASEA:
			result = "CNASEA";
			break;
		case AUTRES_SUBVENTIONS:
			result = "Autres subventions";
			break;
		// Recette de type Autre produits de gestion courante,
		case COLLECTE:
			result = "Collecte";
			break;
		case COTISATION:
			result = "Cotisation";
			break;
		// Recette de type Contributions volontaires en nature
		case BENEVOLAT:
			result = "Bénévolat";
			break;
		case PRESTATIONS_NATURE:
			result = "Prestations en nature";
			break;
		case DONS_NATURE:
			result = "Dons en nature";
			break;
		}
		return result;
	}

	public static List<TypeCompte> getTypeDepenses() {
		List<TypeCompte> results = new LinkedList<TypeCompte>();

		// Depense de type Achat
		results.add(TypeCompte.MATIERE_PREMIERE_FOURNITURE);
		results.add(TypeCompte.FOURNITURES_NON_STOCKAGE);
		results.add(TypeCompte.FOURNITURES_ENTRETIEN);
		results.add(TypeCompte.AUTRE_FOURNITURES);
		results.add(TypeCompte.ACHAT_ETURE_PRESTATION_SERVICE);
		results.add(TypeCompte.ACHAT_DE_MARCHANDISES);
		
		// Depense de type Service Exterieures
		results.add(TypeCompte.SOUS_TRAITANCE_GENERAL);
		results.add(TypeCompte.LOCATIONS);
		results.add(TypeCompte.ENTRETIEN_REPARATION);
		results.add(TypeCompte.ASSURANCE);
		results.add(TypeCompte.DOCUMENTATION);
		results.add(TypeCompte.DIVERS);
		
		// Depense de type Autre service exterieurs
		results.add(TypeCompte.RENUMERATION_INTERMEDIAIRE_HONORAIRE);
		results.add(TypeCompte.PUBLICITE_PUBLICATION_RELATION_PUBLIQUES);
		results.add(TypeCompte.DEPLACEMENT_MISSIONS_RECEPTION);
		results.add(TypeCompte.FRAIS_POSTAUX_FRAI_TELECOMMUNICATION);
		results.add(TypeCompte.SERVICES_BANCAIRES_AUTRE);
		
		// Depense de type Impots taxes et versement assimilés
		results.add(TypeCompte.IMPOTS_TAXE_RENUMERATION);
		results.add(TypeCompte.AUTRE_IMPOTS_TAXE);
		
		// Depense de type Charges de personnel
		results.add(TypeCompte.RENUMERATION_DU_PERSONNEL);
		results.add(TypeCompte.CHARGES_SECURITE_SOCIALE);
		results.add(TypeCompte.AUTRES_CHARGES_PERSONNEL);
		
		// Depense de type Autre charges de gestion courante
		results.add(TypeCompte.DROITS_AUTEURS_REPRODUCTION);
		results.add(TypeCompte.COTISATIONS);
		
		// Depense de type Emplois des contributions volontaires en nature
		results.add(TypeCompte.SECOURS_NATURE);
		results.add(TypeCompte.MISE_DISPOSITION_GRATUIRE_BIEN_SERVICE);
		results.add(TypeCompte.PERSONNEL_BENEVOLE);

		return results;
	}
	
	public static List<TypeCompte> getTypeRecettes(){
		List<TypeCompte> results = new LinkedList<TypeCompte>();
		
		// Recette de type Ventes
		results.add(TypeCompte.VENTE_MARCHANDISES);
		results.add(TypeCompte.VENTE_PRODUITS_FINIS);
		results.add(TypeCompte.VENTE_PRESTATION_SERVICE);
		
		// Recette de type Subventions d'exploitation
		results.add(TypeCompte.ETAT);
		results.add(TypeCompte.REGION);
		results.add(TypeCompte.DEPARTEMENT);
		results.add(TypeCompte.COMMUNES);
		results.add(TypeCompte.ORGANISMES_SOCIAUX);
		results.add(TypeCompte.EUROPE);
		results.add(TypeCompte.CNASEA);
		results.add(TypeCompte.AUTRES_SUBVENTIONS);
		
		// Recette de type Autre produits de gestion courante,
		results.add(TypeCompte.COLLECTE);
		results.add(TypeCompte.COTISATION);
		
		// Recette de type Contributions volontaires en nature
		results.add(TypeCompte.BENEVOLAT);
		results.add(TypeCompte.PRESTATIONS_NATURE);
		results.add(TypeCompte.DONS_NATURE);
		
		return results;
	}
}
