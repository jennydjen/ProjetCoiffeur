package com.example.projetcoiffeur.DAO.interfaces;

import java.util.List;

import com.example.projetcoiffeur.entity.Client;

public interface ClientDAOInteface extends GenericDAO<Client>{
	/**
	 * Changement de l'état du client ( actif / Inactif ) 
	 * @param id
	 */
	public void changementEtatClient(long id);
	/**
	 * Lister tous les clients de la table
	 * @return
	 */
	public List<Client> findAllContact();

}
