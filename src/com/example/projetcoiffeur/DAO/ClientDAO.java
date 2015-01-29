package com.example.projetcoiffeur.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.projetcoiffeur.DAO.interfaces.ClientDAOInteface;
import com.example.projetcoiffeur.DAO.interfaces.GenericDAO;
import com.example.projetcoiffeur.entity.Client;

public class ClientDAO implements ClientDAOInteface{
	@PersistenceContext
	private EntityManager em;
	
	//CREATE, UPDATE, READ, DELETE
	
	
	@Override
	public Client create(Client t) {
		// TODO Auto-generated method stub
		this.em.persist(t);
		return t;
	}
	
	@Override
	public Client update(Client t) {
		
		return this.em.merge(t);
	}

	@Override
	public Client find(long id) {
		// TODO Auto-generated method stub
		Client t= this.em.find(Client.class, id);
		return t;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Changement de l'état du client ( actif / Inactif ) 
	 * @param id
	 */
	public void changementEtatClient(long id){
		Client client = find(id);
		//1 = inactif
		//0 = actif
		if (client.isInactif()){
			client.setInactif(false);
		}else{
			client.setInactif(true);
		}
	}
	
	public List<Client> findAllContact(){
		return em.createNamedQuery("client.findAll", Client.class).getResultList();
		
	}

	
	
}
