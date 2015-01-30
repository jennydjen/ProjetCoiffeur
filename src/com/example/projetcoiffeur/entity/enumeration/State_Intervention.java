package com.example.projetcoiffeur.entity.enumeration;

public enum State_Intervention {

	FAIT, A_FAIRE, ANNULE;

	public String toString() {
		String result = "";

		switch (this) {
		case A_FAIRE:
			result = "A faire";
			break;
		case ANNULE:
			result = "Annulé";
			break;
		case FAIT:
			result = "Fait";
			break;
		}

		return result;
	};
}
