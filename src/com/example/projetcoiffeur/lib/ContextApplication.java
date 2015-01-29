package com.example.projetcoiffeur.lib;

import com.example.projetcoiffeur.entity.enumeration.TypeCompte;
import com.example.projetcoiffeur.entity.enumeration.Type_Paiement;

public class ContextApplication {

	public static String LOGIN = "admin";
	public static String PASSWORD = "admin";

	public static String getIntitul�TypeCompte(TypeCompte type) {
		String result = "";
		switch (type) {
		// DEPENSES
		// Depense de type Achat
		case MATIERE_PREMIERE_FOURNITURE:
			result = "Mati�res premi�res � Fournitures";
			break;
		case FOURNITURES_NON_STOCKAGE:
			result = "Fournitures non stockables (eau, �lectricit�)";
			break;
		case FOURNITURES_ENTRETIEN:
			result = "Fournitures d'entretien et de petit �quipement";
			break;
		case AUTRE_FOURNITURES:
			result = "Autres fournitures";
			break;
		case ACHAT_ETURE_PRESTATION_SERVICE:
			result = "Achat d'�tude et de prestation de service";
			break;
		case ACHAT_DE_MARCHANDISES:
			result = "Achats de marchandises";
			break;
		// Depense de type Service Exterieures
		case SOUS_TRAITANCE_GENERAL:
			result = "Sous traitance g�n�rale";
			break;
		case LOCATIONS:
			result = "Locations";
			break;
		case ENTRETIEN_REPARATION:
			result = "Entretien et r�paration";
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
			result = "R�mun�ration d'interm�diaires et honoraires";
			break;
		case PUBLICITE_PUBLICATION_RELATION_PUBLIQUES:
			result = "Publicit�, publication et relations publiques";
			break;
		case DEPLACEMENT_MISSIONS_RECEPTION:
			result = "D�placements, missions et r�ception";
			break;
		case FRAIS_POSTAUX_FRAI_TELECOMMUNICATION:
			result = "Frais postaux et frais de t�l�communication";
			break;
		case SERVICES_BANCAIRES_AUTRE:
			result = "Services bancaires, autres";
			break;
		// Depense de type Impots taxes et versement assimil�s
		case IMPOTS_TAXE_RENUMERATION:
			result = "Imp�ts et taxes sur r�mun�ration";
			break;
		case AUTRE_IMPOTS_TAXE:
			result = "Autres imp�ts et taxes";
			break;
		// Depense de type Charges de personnel
		case RENUMERATION_DU_PERSONNEL:
			result = "R�mun�ration du personnel";
			break;
		case CHARGES_SECURITE_SOCIALE:
			result = "Charges de s�curit� sociale";
			break;
		case AUTRES_CHARGES_PERSONNEL:
			result = "Autres charges de personnel";
			break;
		// Depense de type Autre charges de gestion courante
		case DROITS_AUTEURS_REPRODUCTION:
			result = "Droits d'auteurs et de reproduction (SACEM)";
			break;
		case COTISATIONS:
			result = "Cotisations (li�es � la vie statutaire)";
			break;
		// Depense de type Emplois des contributions volontaires en nature
		case SECOURS_NATURE:
			result = "Secours en nature";
			break;
		case MISE_DISPOSITION_GRATUIRE_BIEN_SERVICE:
			result = "Mise � disposition gratuite de biens et services";
			break;
		case PERSONNEL_BENEVOLE:
			result = "Personnel b�n�vole";
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
			result = "R�gion";
			break;
		case DEPARTEMENT:
			result = "D�partement";
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
			result = "B�n�volat";
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
			result = "Ch�que";
			break;
		case LIQUIDE:
			result = "Esp�ce";
			break;
		}
		return result;
	}
}
