package com.example.projetcoiffeur.DAO.interfaces;

import java.util.Date;
import java.util.List;

import com.example.projetcoiffeur.entity.Client;
import com.example.projetcoiffeur.entity.Intervention;

/* test */
public interface InterventionDAOInterface extends GenericDAO<Intervention> {

	// Retourne la liste des interventions
	public List<Intervention> findAllIntervention();

	public List<Intervention> findOfTheDay(Date d);
	public List<Intervention> findAllByClient(Client c);

}
