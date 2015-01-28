package com.example.projetcoiffeur.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.projetcoiffeur.entity.Client;

public class ClientDAO implements GenericDAO<Client>{
	@PersistenceContext
	private EntityManager em;

	@Override
	public Client create(Client t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client update(Client t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}
	
	//CREATE, UPDATE, READ, DELETE
	
	
}
