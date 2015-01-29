package com.example.projetcoiffeur.EJB.interfaces;

import java.util.Date;
import java.util.List;

import com.example.projetcoiffeur.entity.Client;
import com.example.projetcoiffeur.entity.Intervention;
import com.example.projetcoiffeur.entity.enumeration.State_Intervention;

/**
 * Interface de l'EJB avec les méthodes spécifiques à l'intervention + 
 * Hérite de GenericEJBInterface pour avoir les méthodes communes
 * @author Jenny
 *
 */
public interface InterventionEJBInterface extends GenericEJBInterface<Intervention>{
	
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
	public List<Intervention> findAllByClient(Client c);
	
	/**
	 * Modifier l'etat de l'intervention
	 * @param id long : Id de l'intervention
	 * @param state State_Intervention : etat qu'on veut appliquer a l'intervention
	 */
	public void setState(long id, State_Intervention state);
}
