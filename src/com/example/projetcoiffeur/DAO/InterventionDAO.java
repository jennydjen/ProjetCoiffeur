package com.example.projetcoiffeur.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.projetcoiffeur.DAO.interfaces.InterventionDAOInterface;
import com.example.projetcoiffeur.entity.Intervention;

public class InterventionDAO implements InterventionDAOInterface {

	@PersistenceContext
	private EntityManager em;
	
	//CREATE, UPDATE, READ, DELETE
	
	
	@Override
	public Intervention create(Intervention t) {
		// TODO Auto-generated method stub
		this.em.persist(t);
		return t;
	}
	
	@Override
	public Intervention update(Intervention t) {
		
		return this.em.merge(t);
	}

	@Override
	public Intervention find(long id) {
		// TODO Auto-generated method stub
		Intervention t= this.em.find(Intervention.class, id);
		return t;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub	
	}
	
	public List<Intervention> findAllIntervention(){
		return em.createNamedQuery("Intervention.findAll", Intervention.class).getResultList();
		
	}
}
