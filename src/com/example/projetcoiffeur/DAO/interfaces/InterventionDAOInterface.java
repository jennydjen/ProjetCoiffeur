package com.example.projetcoiffeur.DAO.interfaces;

import java.util.List;

import com.example.projetcoiffeur.entity.Intervention;


public interface InterventionDAOInterface extends GenericDAO<Intervention>{

	//Retourne la liste des interventions
	public List<Intervention> findAllIntervention();

}
