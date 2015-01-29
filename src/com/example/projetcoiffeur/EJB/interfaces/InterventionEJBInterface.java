package com.example.projetcoiffeur.EJB.interfaces;

import java.util.Date;
import java.util.List;

import com.example.projetcoiffeur.entity.Intervention;

/**
 * Interface de l'EJB
 * @author Jenny
 *
 */
public interface InterventionEJBInterface {

	/**
	 * Créer une intervention
	 * @param intervention Intervention
	 * @return Intervention
	 */
	public Intervention create(Intervention intervention);

	/**
	 * Mettre à jour une intervention
	 * @param intervention Intervention
	 * @return Intervention
	 */
	public Intervention update(Intervention intervention);

	/**
	 * Trouver une intervention selon son ID
	 * @param id long
	 * @return Intervention
	 */
	public Intervention find(long id);

	/**
	 * Supprimer une intervention
	 * @param id long
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
	 * @param id_client long
	 * @return List<Intervention>
	 */
	public List<Intervention> findAllByClient(long id_client);
}
