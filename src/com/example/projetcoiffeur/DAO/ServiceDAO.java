package com.example.projetcoiffeur.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.projetcoiffeur.DAO.interfaces.GenericDAO;
import com.example.projetcoiffeur.DAO.interfaces.ServiceDAOInterface;
import com.example.projetcoiffeur.entity.Service;

public class ServiceDAO implements ServiceDAOInterface{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Service create(Service t) {
		// TODO Auto-generated method stub
		this.em.persist(t);
		return t;
	}

	@Override
	public Service update(Service t) {
		// TODO Auto-generated method stub
		return this.em.merge(t);
	}

	@Override
	public Service find(long id) {
		// TODO Auto-generated method stub
		Service t = this.em.find(Service.class, id);
		return t;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Changemnt de l'etat du service (actif/iactif)
	 * @param id
	 * 
	 */

	@Override
	public void ChangementEtatService(Long id) {
		// 1=> inactif  0=> actif
		Service service = find(id);
		
		if (service.isEtat()){
			service.setEtat(false);
		}else{
				service.setEtat(true);
		}
	}
		
	

	@Override
	public List<Service> findAllService() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("service.findAll", Service.class).getResultList();
	}
	
}
