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
			result = "Ch�que";
			break;
		case LIQUIDE:
			result = "Esp�ce";
			break;
		}
		return result;
	};
}
