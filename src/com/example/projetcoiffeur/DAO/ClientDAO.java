package com.example.projetcoiffeur.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.projetcoiffeur.entity.Client;

public class ClientDAO implements GenericDAO<Client>{
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
	
	public List<Client> findAllContact(){
		return em.createNamedQuery("client.findAll", Client.class).getResultList();
		
	}
	
	
	
	
}
