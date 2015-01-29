package com.example.projetcoiffeur.DAO.interfaces;

import java.util.List;

import com.example.projetcoiffeur.entity.Service;

public interface ServiceDAOInterface extends GenericDAO<Service>{
	/**
	 * Changement de l'état du service (actif / inactif)
	 * @param id
	 * 
	 */
	public void ChangementEtatService (Long id);
	/**
	 * Lister tous les elements de la table Service
	 * @return
	 * 
	 */
	public List<Service> findAllService();
}
