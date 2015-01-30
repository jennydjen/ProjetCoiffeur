package com.example.projetcoiffeur.entity.enumeration;

public enum Type_Paiement {

	CARTE_BANCAIRE, CHEQUE, LIQUIDE;

	public String toString() {
		String result = "";
		switch (this) {
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
	};
}
