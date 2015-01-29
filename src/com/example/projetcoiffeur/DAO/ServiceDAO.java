package com.example.projetcoiffeur.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.projetcoiffeur.entity.Service;

public class ServiceDAO implements GenericDAO<Service>{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Service create(Service t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Service update(Service t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Service find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}
	
}
