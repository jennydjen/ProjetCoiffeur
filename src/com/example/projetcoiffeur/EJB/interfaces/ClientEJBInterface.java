package com.example.projetcoiffeur.EJB.interfaces;

import java.util.List;

import com.example.projetcoiffeur.entity.Client;

public interface ClientEJBInterface extends GenericEJBInterface<Client>{
	
	/**
	 * Modifier l'état de présence du client s
	 * @param id
	 */
	public void changementEtatClient(long id);
	
	/**
	 * Lister tous les clients de la table
	 * @return
	 */
	public List<Client> findAllContact();
	
}
