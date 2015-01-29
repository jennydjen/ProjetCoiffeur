package com.example.projetcoiffeur.EJB.interfaces;

import java.util.Date;
import java.util.List;

import com.example.projetcoiffeur.entity.Intervention;
import com.example.projetcoiffeur.entity.enumeration.State_Intervention;

/**
 * Interface de l'EJB
 * @author Jenny
 *
 */
public interface InterventionEJBInterface {

	/**
	 * Créer une intervention
	 * @param intervention Intervention : l'intervention qu'on veut créer
	 * @return Intervention
	 */
	public Intervention create(Intervention intervention);

	/**
	 * Mettre à jour une intervention
	 * @param intervention Intervention : l'intervention qu'on veut mettre à jour
	 * @return Intervention
	 */
	public Intervention update(Intervention intervention);

	/**
	 * Trouver une intervention selon son ID
	 * @param id long : id de l'intervention
	 * @return Intervention
	 */
	public Intervention find(long id);

	/**
	 * Supprimer une intervention
	 * @param id long : id de l'intervention
	 */
	public void delete(long id);

	/**
	 * Trouver toutes les interventions
	 * @return List<Intervention>
	 */
	public List<Intervention> findAll();
		
	/**
	 * Trouver les interventions par date
	 * @return List<Intervention>
	 */
	public List<Intervention> findOfTheDay(Date date);
	
	/**
	 * Trouver les interventions pour un client donné
	 * @param id_client long : id du client
	 * @return List<Intervention>
	 */
	public List<Intervention> findAllByClient(long id_client);
	
	/**
	 * Modifier l'etat de l'intervention
	 * @param id long : Id de l'intervention
	 * @param state State_Intervention : etat qu'on veut appliquer a l'intervention
	 */
	public void setState(long id, State_Intervention state);
}
