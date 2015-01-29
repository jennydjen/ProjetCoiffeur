package com.example.projetcoiffeur.lib;

import com.example.projetcoiffeur.entity.enumeration.TypeCompte;
import com.example.projetcoiffeur.entity.enumeration.Type_Paiement;

public class ContextApplication {

	public static String LOGIN = "admin";
	public static String PASSWORD = "admin";

	public static String getIntituléTypeCompte(TypeCompte type) {
		String result = "";
		switch (type) {
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

	public static String getLibelleTypePaiment(Type_Paiement type) {
		String result = "";
		switch (type) {
		case CARTE_BANCAIRE:
			result = "Carte bancaire";
			break;
		case CHEQUE:
			result = "Chèque";
			break;
		case LIQUIDE:
			result = "Espèce";
			break;
		}
		return result;
	}
}
